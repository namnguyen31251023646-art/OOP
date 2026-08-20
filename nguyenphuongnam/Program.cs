using System;

public class Student
{
    public string name;
    public double score;
    public static int totalStudents = 0;

    // Constructor
    public Student(string name, double score)
    {
        this.name = name;
        this.score = score;
        totalStudents++;
    }

    // Instance method
    public string GetName()
    {
        return this.name;
    }

    // Instance method: GetScore
    public double GetScore()
    {
        return this.score;
    }

    // Instance method: IsPassed
    public bool IsPassed()
    {
        return this.score >= 5.0;
    }

    // Instance method: GetClassification
    public string GetClassification()
    {
        if (this.score >= 8.0)
        {
            return "Excellent";
        }
        else if (this.score >= 6.5)
        {
            return "Good";
        }
        else if (this.score >= 5.0)
        {
            return "Average";
        }
        else
        {
            return "Weak";
        }
    }

    // Static method: GetTotalStudents
    public static int GetTotalStudents()
    {
        return totalStudents;
    }

    // Static method: FindTopStudent
    public static Student FindTopStudent(Student[] students)
    {
        Student topStudent = students[0];

        foreach (Student student in students)
        {
            if (student.GetScore() > topStudent.GetScore())
            {
                topStudent = student;
            }
        }

        return topStudent;
    }

    // Static method: CalculateAverageScore
    public static double CalculateAverageScore(Student[] students)
    {
        double totalScore = 0;

        foreach (Student student in students)
        {
            totalScore += student.GetScore();
        }

        return totalScore / students.Length;
    }
}

class Program
{
    static void Main(string[] args)
    {
        // Create an array of Student objects
        Student[] students =
        {
            new Student("An", 8.5),
            new Student("Binh", 7.2),
            new Student("Chi", 5.8),
            new Student("Dung", 9.1),
            new Student("Huy", 4.5)
        };

        // Print total number of students
        Console.WriteLine("Total students: " + Student.GetTotalStudents());

        Console.WriteLine("\nStudent List:");
        Console.WriteLine("-----------------------------");

        // Print student information
        foreach (Student student in students)
        {
            Console.WriteLine(
                "Name: " + student.GetName() +
                " | Score: " + student.GetScore() +
                " | Classification: " + student.GetClassification() +
                " | Status: " + (student.IsPassed() ? "Passed" : "Failed")
            );
        }

        // Find top student
        Student topStudent = Student.FindTopStudent(students);

        Console.WriteLine("\nTop Student:");
        Console.WriteLine(
            topStudent.GetName() +
            " - Score: " +
            topStudent.GetScore()
        );

        // Calculate average score
        double averageScore = Student.CalculateAverageScore(students);

        Console.WriteLine("\nClass Average Score: " + averageScore.ToString("F2"));
    }
}

