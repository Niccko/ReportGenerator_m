import java.util.*;

public class MemberHandler {
    private Map<String,String> repoLinks = new HashMap<>();
    public MemberHandler(){
        repoLinks.put("Анисимов Андрей","https://github.com/Unusualuser/javan/tree/master/Projects/Main");
        repoLinks.put("Гибова Екатерина","https://github.com/katyagibova/java_proj");
        repoLinks.put("Гонец Артем","https://github.com/Gonets-Artem/Java-Mirea");
        repoLinks.put("Гридасов Егор","https://github.com/EgorCry/Java_MIREA_tasks");
        repoLinks.put("Гудаев Исмаил","https://github.com/gigagibi/JAVA_MIREA_PRACTICE");
        repoLinks.put("Денисенко Алексей","https://github.com/alexeydenisenkoofficial/zanoza");
        repoLinks.put("Дударев Максим","https://github.com/MrCrashLab/JavaPractice");
        repoLinks.put("Ермаков Илья","https://github.com/ilermak/mirea_java");
        repoLinks.put("Игамбердыев Максудбек","https://github.com/Maksudbek-I/Practice");
        repoLinks.put("Карвасарный Глеб","https://github.com/Merfarion/MireaJava");
        repoLinks.put("Комаров Александр","https://github.com/ddraco-d/JavaLabs");
        repoLinks.put("Кондрашов Михаил","https://github.com/MihKon/Java-3sem");
        repoLinks.put("Лысов Станислав","https://github.com/IceTeaIsLife/edu_java");
        repoLinks.put("Ляхов Андрей","https://github.com/Srtyewiop/JavaPract");
        repoLinks.put("Махонин Алексей","https://github.com/sh4rkizz/successfullSuccess");
        repoLinks.put("Михайлов Артем","https://github.com/Flexstor/allPractices");
        repoLinks.put("Мотькин Илья","https://github.com/xresou/final");
        repoLinks.put("Нецвет Михаил","https://github.com/Netlighter/java-practice");
        repoLinks.put("Низамутдинова Ангелина","https://github.com/GeliaNiz/Java_Practice");
        repoLinks.put("Ороновская Александра","https://github.com/SunnyientDev/Stepik_New_Courses/tree/master/Java%20University%20course");
        repoLinks.put("Парамонов Олег","https://github.com/paramonov404/My_projects_Java");
        repoLinks.put("Пучков Алексей","https://github.com/AlexKennethMiles/Java_Lab");
        repoLinks.put("Рыхлов Михаил","https://github.com/Miki-san/Java_02");
        repoLinks.put("Середа Илья","https://github.com/ilyamarvin/JavaPractice");
        repoLinks.put("Суринов Роман","https://github.com/TheHarald/JAVA_2020");
        repoLinks.put("Суроегин Константин","https://github.com/xinchao-bojan/java/tree/practice_2");
        repoLinks.put("Шеханин Максим","https://github.com/Niccko/Java_IVBO-07");
        repoLinks.put("Шикалов Данила","https://github.com/DanilaShikalov/Java_Prac");
    }

    public String getUsername(String name){
        StringBuilder username = new StringBuilder();
        name = repoLinks.get(name);
        name = name.replace("https://github.com/","");
        int i = 0;
        while(name.charAt(i)!='/'){
            username.append(name.charAt(i));
            i++;
        }
        return username.toString();
    }

    public String getRepoName(String name){
        StringBuilder repoName = new StringBuilder();
        name = repoLinks.get(name);
        int i = name.length()-1;
        while(name.charAt(i)!='/') i--;
        i++;
        while(i<name.length()){
            repoName.append(name.charAt(i));
            i++;
        }
        return repoName.toString();
    }

    public List<String> getNames(){
        List<String> list = new ArrayList<>(repoLinks.keySet());
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (int)o1.charAt(0)-(int)o2.charAt(0);
            }
        });
        return list;
    }
}
