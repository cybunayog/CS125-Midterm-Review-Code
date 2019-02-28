Public class Client {

Public static void main(String args []){
    ArrayList<Student> stud = new ArrayList<Student>();
    stud.add( new Student(“Cy”, “beta”));
    stud.add( new Student(“Seth”, “father”));
    stud.add( new Student(“Nauj”, “senpai”));
    stud.add(new Student(“eww”, “eww”));

    //writing file
    FileOutputStream fos = null;
    PrintWriter pw = null;

    Try {


    } catch (FileNotFoundException e) {

    } catch(Exception e) {


    }

    //reading file


    }

}
