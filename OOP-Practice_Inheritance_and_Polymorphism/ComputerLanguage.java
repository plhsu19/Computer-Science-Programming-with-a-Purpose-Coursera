/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

public class ComputerLanguage extends Language {

    protected String gender;

    public ComputerLanguage(String name, int num, String region, String gender) {
        super(name, num, region, "Subject-Verb-Object");
        this.gender = gender;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.printf("Language %s is using gender %s.%n", name, gender);
    }
}
