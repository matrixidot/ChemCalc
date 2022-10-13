import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    // TODO: Refactor this code into a different class called CalcWeight instead of bloating main class.
    // TODO: Add features for converting into moles, particles, and molar volume
    public HashMap<String, Double> elements = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        System.out.println("If your compound contains parenthesis like (C2H3)2 then distribute the 2 (in this case) across the elements inside and then enter them");
        System.out.println("(C2H3)2 -> C4H6");
        System.out.println("Enter compound as a comma seperated list, Ex: C4H6 -> C4,H6");
        main.parseCompoundAndWeights(sc.nextLine());

    }

    /*
     * Splits the string into an array of strings
     * Each element in the array can have a number attached to it indicating the amount of that element in the compound
     * This then calls the API code to fetch the element's weight and then finally print out the hashMap with the Elements and their total Weight
     */
    public void parseCompoundAndWeights(String compound) {
        StringBuilder sb = new StringBuilder();
        String[] arr = compound.split(",");
        for (String s : arr) {
            sendRequestAndParseData(s, IfRepeatGetRepeats(s));
            sb.append(s);
        }
        System.out.println("The molar mass of: " + sb + " = " + sum());
    }

    private double sum() {
        double sum = 0;
        for (String s : elements.keySet()) {
            sum += elements.get(s);
        }
        return sum;
    }

    public int IfRepeatGetRepeats(String element) {
        if (element.length() >= 2 && Character.isDigit(element.charAt(1))) {
            return Integer.parseInt(new StringBuilder(element).deleteCharAt(0).toString());
        }

        if (element.length() >= 3 && Character.isDigit(element.charAt(2))) {
            element = new StringBuilder(element).deleteCharAt(0).toString();
            return Integer.parseInt(new StringBuilder(element).deleteCharAt(0).toString());
        }
        return 1;
    }

    // Gets the atomic weight of the specified element.
    public void sendRequestAndParseData(String element, int repeats) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url("https://periodic-table-elements-info.herokuapp.com/element/symbol/" + fixElement(element)).method("GET", null).build();
        try {
            Response response = client.newCall(request).execute();
            String elementStr = response.body().string();
            for (int i = 0; i < repeats; i++) {
                addToMap(element, parseWeight(elementStr));
            }
            System.out.println("The weight of: " + element + " is: " + parseWeight(elementStr) + " x " + repeats + " = " + elements.get(element));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Used to remove the Number at the end of each element's symbol to allow for the API to understand it.
    private String fixElement(String element) {
        // Example H2
        if (element.length() >= 2 && Character.isDigit(element.charAt(1))) {
            return Character.toString(element.charAt(0));
        }
        // Example Cl2
        if (element.length() >= 3 && Character.isDigit(element.charAt(2))) {
            return new StringBuilder(element).delete(2, element.length()).toString();
        }
        // Anything without a number
        return element;
    }

    // Adds the element and its weight to the hashmap.
    // If it already exists in the map the value is increased.
    private void addToMap(String element, double weight) {
        if (elements.containsKey(element)) elements.replace(element, weight + elements.get(element));
        else elements.put(element, weight);
    }

    // Takes JSON response and grabs the weight of the element
    public double parseWeight(String response) throws IOException {
        response = prettifyJson(response);
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(response);
            JSONObject jsonObject = (JSONObject) obj;
            String weight = (String) jsonObject.get("atomicMass");
            StringBuilder sb = new StringBuilder(weight);
            weight = sb.delete(weight.length()-3, weight.length()).toString();
            return Double.parseDouble(weight);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Literally removes the starting and ending []
    private String prettifyJson(String response) {
        StringBuilder sb = new StringBuilder(response);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.toString().length()-1);
        response = sb.toString();
        return response;
    }

}
