package sdp;

import org.junit.Test;


import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(processGrades(scanner));
  }

  private static String processGrades(Scanner scanner) {
    double class_acc = 0;
    double grade_acc = 0;
    double final_gpa = 0;
    String junk = "junk";
    while (scanner.hasNextLine()){

      junk = scanner.next();
      junk = scanner.next();
      String lettergrade = scanner.next();

      if (lettergrade == "A")
      {
        grade_acc += 4.0;
        class_acc++;
      }
      else if (lettergrade == "A-") {
        grade_acc += 3.67;
        class_acc++;
      }
      else if (lettergrade == "B+"){
        grade_acc += 3.33;
        class_acc++;
      }
      else if (lettergrade == "B"){
        grade_acc += 3.0;
        class_acc++;
      }
      else if (lettergrade == "B-"){
        grade_acc += 2.67;
        class_acc++;
      }
      else if (lettergrade == "C+"){
        grade_acc += 2.33;
        class_acc++;
      }
      else if (lettergrade == "C"){
        grade_acc += 2.0;
        class_acc++;
      }
      else if (lettergrade == "C-"){
        grade_acc += 1.67;
        class_acc++;
      }
      else if (lettergrade == "D+"){
        grade_acc += 1.33;
        class_acc++;
      }
      else if (lettergrade == "D"){
        grade_acc += 1.0;
        class_acc++;
      }
      else {
        class_acc++;
      }



    }
    if(class_acc == 0){
      return "Courses: 0\nGPA: 0.00\n";
    }
    final_gpa = grade_acc / class_acc;
    return "Courses: " + String.valueOf(class_acc) + "GPA: " + String.valueOf(final_gpa);
  }



  @Test
  public void emptyGradeListReportsZeroGpaAndNoCourses() {
    assertTotalsOfList_Are("", "Courses: 0\nGPA: 0.00\n");
  }

  @Test
  public void scannerNext()
  {
    Scanner scanner = new Scanner("Cats are not dogs");
    System.out.println(scanner.next());
    System.out.println(scanner.next());

  }

  @Test
  public void singleCourseGradeReportsItself() {
    assertTotalsOfList_Are("CS 234        A ", "Courses: 1\nGPA: 4.00\n");
    assertTotalsOfList_Are("MAT    234    A-", "Courses: 1\nGPA: 3.67\n");
    assertTotalsOfList_Are("ENGR 121      B+", "Courses: 1\nGPA: 3.33\n");
    assertTotalsOfList_Are("CS 234         B", "Courses: 1\nGPA: 3.00\n");
    assertTotalsOfList_Are("CS 234        B-", "Courses: 1\nGPA: 2.67\n");
    assertTotalsOfList_Are("ENGR 011     C+ ", "Courses: 1\nGPA: 2.33\n");
    assertTotalsOfList_Are("ENGR 101      C ", "Courses: 1\nGPA: 2.00\n");
    assertTotalsOfList_Are("ENGR 101    C-\n", "Courses: 1\nGPA: 1.67\n");
    assertTotalsOfList_Are("ENGR 101      D+", "Courses: 1\nGPA: 1.33\n");
    assertTotalsOfList_Are("CS 122L        D", "Courses: 1\nGPA: 1.00\n");
    assertTotalsOfList_Are("CS 122L        F", "Courses: 1\nGPA: 0.00\n");
  }

  @Test
  public void multipleCoursesAreAllComputed() {
    assertTotalsOfList_Are(
            "CS 234        A \nMAT 111      B",
            "Courses: 2\nGPA: 3.50\n");
    assertTotalsOfList_Are(
            "CS 234        A \nMAT 111      B\nCS 122     B-\n",
            "Courses: 3\nGPA: 3.22\n");

  }

  @Test
  public void withdrawnCoursesDontCountTowardsCoursesTaken() {
    assertTotalsOfList_Are("CS 122L      W", "Courses: 0\nGPA: 0.00\n");
    assertTotalsOfList_Are(
            "CS 234        A \nMAT 111      B\nCS 122     W\n",
            "Courses: 2\nGPA: 3.50\n");
  }

  private void assertTotalsOfList_Are(String input, String output) {
    assertEquals(output, processGrades(new Scanner(input)));
  }
}
