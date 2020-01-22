package names;

import java.util.Comparator;

/**
* Represents a line from a file of baby name data for a certain year, so each
* entry object has a name, a gender, and the number of instances of babies
* born in that year with that gender. It was also helpful to make the first letter
* of that name an instance variable because it is useful in finding the most
* common name starting with that letter for a range of years.
*/
public class BabyEntry implements Comparable<BabyEntry> {
    private String name;
    private String gender;
    private Integer nameCount;
    private Character firstLetter;

    /**
    * Create BabyEntry by splitting comma delimited line from a file
    */
    public BabyEntry(String line) {
        String[] data = line.split(",");
        name = data[0];
        gender = data[1];
        nameCount = Integer.parseInt(data[2]);
        firstLetter = name.charAt(0);
        firstLetter = Character.toLowerCase(firstLetter);
    }

    public Character getFirstLetter() {
        return firstLetter;
    }

    public Integer getNameCount() {
        return nameCount;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(BabyEntry otherBabyEntry) {
        if (this.getNameCount() > otherBabyEntry.getNameCount()) {
            return -1;
        }
        if (this.getNameCount() == otherBabyEntry.getNameCount()) {
            if (this.getName().compareTo(otherBabyEntry.getName()) < 0) {
                return -1;
            }
            if (this.getName().compareTo(otherBabyEntry.getName()) == 0) {
                if (this.getGender().compareTo(otherBabyEntry.getGender()) < 0) {
                    return -1;
                }
            }
        }
        return 1;
    }
}
