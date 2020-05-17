/* *****************************************************************************
 *  Name: Pei-Lun Hsu
 *  Date: 17.05.2020
 *  Description: Practice of Inheritance & Polymorphism "Language Family"
 **************************************************************************** */
class Mayan extends Language {

    public Mayan(String name, int numSpeakers) {
        super(name, numSpeakers, "Central America", "verb-object-subject");
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.printf("Fun fact: %s is an ergative language.%n", name);
    }
}
