import org.eclipse.egit.github.core.*;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.ContentsService;
import org.eclipse.egit.github.core.service.PullRequestService;
import org.eclipse.egit.github.core.service.RepositoryService;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        GitHubClient client = new GitHubClient();
        client.setOAuth2Token("bced7f6bfd52a1f8493be9d2dac064a7b032d7cc");


        RepositoryService repoService = new RepositoryService(client);


            Repository repo = repoService.getRepository("Niccko","Java_IVBO-07");

            // now contents service
            ContentsService contentService = new ContentsService(client);

            List<RepositoryContents> contentList = contentService.getContents(repo);
            for(RepositoryContents content : contentList){
                String fileConent = content.getContent();
                System.out.println(content.getName());
            }

    }
}
