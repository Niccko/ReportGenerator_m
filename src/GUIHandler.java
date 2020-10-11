import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryContents;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GUIHandler extends JFrame {
    public GUIHandler(MemberHandler memHandler, GitHandler gitHandler) throws IOException {
        setSize(700,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        final String[] absPath = {"src"};
        JLabel path = new JLabel(absPath[0]);
        path.setBounds(10,450,200,100);
        JButton selectButton = new JButton("Select");
        selectButton.setBounds(450,10,100,50);

        JPanel mainPanel = new JPanel(null);
        JList<Object> packageList = new JList<>();
        packageList.setBounds(220,10,200,300);
        JComboBox memberList = new JComboBox(memHandler.getNames().toArray());
        memberList.setBounds(10,10,200,50);

        memberList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Repository repo = gitHandler.getRepo((String) memberList.getSelectedItem());
                List<RepositoryContents> packList = gitHandler.getPathContent(repo,"src");
                List<String> packNames = new ArrayList<>();
                for (RepositoryContents rep:packList) {
                    packNames.add(rep.getName());
                }
                packageList.setListData(packNames.toArray());
            }
        });



        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                absPath[0] +="/"+(String)packageList.getSelectedValue();
                path.setText(absPath[0]);
                Repository repo = gitHandler.getRepo((String) memberList.getSelectedItem());
                List<RepositoryContents> packList = gitHandler.getPathContent(repo,absPath[0]);
                List<String> packNames = new ArrayList<>();
                if(packList.get(0).getType() == "file"){

                }
                for (RepositoryContents rep:packList) {
                    packNames.add(rep.getName());
                }
                packageList.setListData(packNames.toArray());
            }
        });




        mainPanel.add(memberList);
        mainPanel.add(packageList);
        mainPanel.add(path);
        mainPanel.add(selectButton);
        add(mainPanel);
    }
}
