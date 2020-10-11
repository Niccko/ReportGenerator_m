import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryContents;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.ContentsService;
import org.eclipse.egit.github.core.service.RepositoryService;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

public class GitHandler {
    private GitHubClient gitClient;
    private RepositoryService repoService;
    private ContentsService contentsService;
    private MemberHandler mHandler;
    public GitHandler(String token){
        gitClient = new GitHubClient();
        gitClient.setCredentials("Niccko","Max541679");
        repoService = new RepositoryService();
        mHandler = new MemberHandler();
        contentsService = new ContentsService();
    }
    public Repository getRepo(String name) {
        try {
            return repoService.getRepository(mHandler.getUsername(name),mHandler.getRepoName(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<RepositoryContents> getRepoPackages(String name) {
        Repository repo = getRepo(name);
        try {
            return contentsService.getContents(repo,"src");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<RepositoryContents> getPathContent(Repository repo,String path){
        try {
            return contentsService.getContents(repo,path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String decodeFile(RepositoryContents file){
        String fileContent = file.getContent();
        return new String(Base64.getMimeDecoder().decode(fileContent.getBytes()));
    }
}
