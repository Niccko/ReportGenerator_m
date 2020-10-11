import org.eclipse.egit.github.core.*;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.ContentsService;
import org.eclipse.egit.github.core.service.PullRequestService;
import org.eclipse.egit.github.core.service.RepositoryService;
//d68d4911dcce714c4619619fc2f1f6ae3f1a11ec
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        MemberHandler mh = new MemberHandler();
        GitHandler gh = new GitHandler("d68d4911dcce714c4619619fc2f1f6ae3f1a11ec");
        List<RepositoryContents> repCont = gh.getRepoPackages("Низамутдинова Ангелина");
        for (RepositoryContents repc: repCont) {
            System.out.println(repc.getName());
        }

    }
}
