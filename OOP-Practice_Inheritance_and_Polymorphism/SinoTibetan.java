/* *****************************************************************************
 *  Name: Pei-Lun Hsu
 *  Date: 17.05.2020
 *  Description: Practice of Inheritance & Polymorphism "Language Family"
 **************************************************************************** */

public class SinoTibetan extends Language {
    public SinoTibetan(String languageName, int speakers) {
        super(languageName, speakers, "Asia", "subject-object-verb");
        if (this.name.contains("Chinese")) this.wordOrder = "subject-verb-object";
    }

}
