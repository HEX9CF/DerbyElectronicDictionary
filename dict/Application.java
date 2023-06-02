package dict;

import dict.data.DatabaseInitializer;
import dict.view.IntegrationView;

/**
 * 应用程序
 *
 * @author HEX9CF
 * @date 2023/06/02
 */
public class Application {
    public static void main(String[] args) {
        new DatabaseInitializer();
        IntegrationView view = new IntegrationView();
    }
}
