import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;

public class FlaskClient {
    public static void main(String[] args) {
        String flaskUrl = "http://localhost:5001"; // Address of the Flask server

        try {
            // Create a URI object for the Flask server request
            URI uri = new URI(flaskUrl + "/");

            // Establish the connection
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("GET");

            // Get the server response
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the server response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Print the server response
                System.out.println("Server response:");
                System.out.println(response.toString());
            } else {
                System.out.println("Error executing the request. Error code: " + responseCode);
            }

            // Close the connection
            connection.disconnect();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
