import org.eclipse.egit.github.core.*;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.ContentsService;
import org.eclipse.egit.github.core.service.PullRequestService;
import org.eclipse.egit.github.core.service.RepositoryService;
//d68d4911dcce714c4619619fc2f1f6ae3f1a11ec
import javax.swing.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        MemberHandler memHandler = new MemberHandler();

        System.out.println(memHandler.getNames().toArray());

        GitHandler gitHandler = new GitHandler("d68d4911dcce714c4619619fc2f1f6ae3f1a11ec");
        SwingUtilities.invokeLater(()->{
            GUIHandler window = null;
            try {
                window = new GUIHandler(memHandler,gitHandler);
            } catch (IOException e) {
                e.printStackTrace();
            }
            window.setVisible(true);
        });
        /*String name = sc.nextLine();
        String temp = sc.nextLine();
        System.out.println(temp);
        List<RepositoryContents> lst = gitHandler.getPathContent(gitHandler.getRepo(name),temp);
        for (RepositoryContents repC:lst) {
            System.out.println(repC.getName());
        }

        temp+="/"+sc.nextLine();
        System.out.println(temp);
        lst = gitHandler.getPathContent(gitHandler.getRepo(name),temp);
        for (RepositoryContents repC:lst) {
            System.out.println(repC.getName());

        }
        temp+="/"+sc.nextLine();
        System.out.println(temp);
        lst = gitHandler.getPathContent(gitHandler.getRepo(name),temp);
        for (RepositoryContents repC:lst) {

        }*/
    }
}
