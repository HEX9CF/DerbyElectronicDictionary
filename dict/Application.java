package dict;

import dict.data.DatabaseInitializer;
import dict.view.IntegrationView;

public class Application {
    public static void main(String[] args) {
        new DatabaseInitializer();
        IntegrationView view = new IntegrationView();
    }
}
