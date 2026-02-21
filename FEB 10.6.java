import java.util.*;

// Parent Class
class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// Inheritance - Doctor
class Doctor extends Person {
    private String specialization;
    private List<Appointment> appointments = new ArrayList<>();  // Composition

    public Doctor(String name, int age, String specialization) {
        super(name, age);
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public void addAppointment(Patient patient, String date) {
        Appointment appointment = new Appointment(patient, date);
        appointments.add(appointment);
        System.out.println("Appointment booked with Dr." + name);
    }

    public void showAppointments() {
        System.out.println("Appointments for Dr." + name);
        for (Appointment a : appointments) {
            System.out.println("Patient: " + a.getPatient().name + 
                               ", Date: " + a.getDate());
        }
    }
}

// Inheritance - Patient
class Patient extends Person {
    private String disease;
    private boolean admitted = true;

    public Patient(String name, int age, String disease) {
        super(name, age);
        this.disease = disease;
    }

    public void discharge() {
        admitted = false;
        System.out.println(name + " has been discharged.");
    }
}

// Composition Class
class Appointment {
    private Patient patient;
    private String date;

    public Appointment(Patient patient, String date) {
        this.patient = patient;
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getDate() {
        return date;
    }
}

// Aggregation Class
class Hospital {
    private String hospitalName;
    private List<Doctor> doctors = new ArrayList<>();

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Doctor " + doctor.getName() + " added to hospital.");
    }
}

// Main Class
public class HospitalManagementSystem {
    public static void main(String[] args) {

        Hospital hospital = new Hospital("City Hospital");

        Doctor doc1 = new Doctor("Ravi", 45, "Cardiologist");
        Doctor doc2 = new Doctor("Meena", 38, "Dermatologist");

        hospital.addDoctor(doc1);
        hospital.addDoctor(doc2);

        Patient p1 = new Patient("Arjun", 30, "Heart Problem");
        Patient p2 = new Patient("Sneha", 25, "Skin Allergy");

        doc1.addAppointment(p1, "12-02-2026");
        doc2.addAppointment(p2, "13-02-2026");

        doc1.showAppointments();
        doc2.showAppointments();

        p1.discharge();
    }
}



