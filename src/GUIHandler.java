import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryContents;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

public class GUIHandler extends JFrame {
    public GUIHandler(MemberHandler memH, GitHandler gitH) throws IOException {
        setSize(1000,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        final String[] absPath = {""};
        JLabel path = new JLabel(absPath[0]);
        path.setBounds(220,10,100,100);

        JTextArea code = new JTextArea();
        code.setBounds(450,80,500,550);
        code.setEnabled(false);

        JPanel mainPanel = new JPanel(null);
        JComboBox<String> memberList = new JComboBox<>(memH.getNames().toArray(new String[0]));
        memberList.setBounds(10,80,200,50);
        JList<String> browser = new JList<String>();
        browser.setBounds(220,80,200,400);
        JButton selectButton = new JButton("Select");
        selectButton.setBounds(10,140,80,25);
        JLabel fileType = new JLabel("Content: ");

        memberList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Repository repo = gitH.getRepo(Objects.requireNonNull(memberList.getSelectedItem()).toString());
                List<RepositoryContents> repoContent = gitH.getPathContent(repo,"");
                Vector<String> contentNames = new Vector<>();
                for (RepositoryContents rc:repoContent) {
                    contentNames.add(rc.getName());
                }
                browser.setListData(contentNames);
            }
        });

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                absPath[0] +="/"+browser.getSelectedValue();
                path.setText(absPath[0]);



                Repository repo = gitH.getRepo(Objects.requireNonNull(memberList.getSelectedItem()).toString());
                List<RepositoryContents> repoContent = gitH.getPathContent(repo,absPath[0]);
                if(repoContent.size()==1 && repoContent.get(0).getType().equals("file")){
                    code.setText(gitH.decodeFile(repoContent.get(0)));
                    return;
                }
                Vector<String> contentNames = new Vector<>();
                for (RepositoryContents rc:repoContent) {
                    contentNames.add(rc.getName());
                }
                browser.setListData(contentNames);
            }
        });

        mainPanel.add(memberList);
        mainPanel.add(browser);
        mainPanel.add(selectButton);
        mainPanel.add(path);
        mainPanel.add(code);
        add(mainPanel);
    }
}
