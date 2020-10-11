import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryContents;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.ContentsService;
import org.eclipse.egit.github.core.service.RepositoryService;

import java.io.IOException;
import java.util.List;

public class GitHandler {
    private GitHubClient gitClient;
    private RepositoryService repoService;
    private ContentsService contentsService;
    MemberHandler mHandler;
    public GitHandler(String token){
        gitClient = new GitHubClient();
        gitClient.setOAuth2Token(token);
        repoService = new RepositoryService();
        mHandler = new MemberHandler();
        contentsService = new ContentsService();
    }
    public Repository getRepo(String name) throws IOException {
        return repoService.getRepository(mHandler.getUsername(name),mHandler.getRepoName(name));
    }

    public List<RepositoryContents> getRepoPackages(String name) throws IOException {
        Repository repo = getRepo(name);
        return contentsService.getContents(repo,"src");
    }
}
