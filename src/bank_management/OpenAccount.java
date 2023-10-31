package bank_management;

public class OpenAccount {
   static String  formno, name, fname, dob, gender, email, marital, address, city, pincode, state, religion, category, income,
            eQualification, occupation, panNo, aadharNo, sc, ea;
   static long AccountNumber;

    public OpenAccount(String formno, long AccountNumber, String name, String fname, String dob, String gender,
            String email, String marital, String address, String city, String pincode, String state) {
        this.formno = formno;
        this.AccountNumber = AccountNumber;
        this.name = name;
        this.fname = fname;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.marital = marital;
        this.address = address;
        this.city = city;
        this.pincode = pincode;
        this.state = state;
    }

    public OpenAccount(String fno, String accountNumber2, String religion, String category, String income,
            String eQualification, String occupation, String panNo, String aadharNo, String sc, String ea) {
        this.religion = religion;
        this.category = category;
        this.income = income;
        this.eQualification = eQualification;
        this.occupation = occupation;
        this.panNo = panNo;
        this.aadharNo = aadharNo;
        this.sc = sc;
        this.ea = ea;
    }

    public OpenAccount() {
    }

    public static void executeQuery() {
        Conn c = new Conn();
        try {
            String query = "insert into signup values('" + formno + "','" + AccountNumber + "','" + name + "','"
                    + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address
                    + "','" + city + "','" + pincode + "','" + state + "')";

            String query1 = "insert into signupTwo values('" + formno + "','" + AccountNumber + "','" + religion + "','"
                    + category + "','" + income + "','" + eQualification + "','" + occupation + "','" + panNo
                    + "','" + aadharNo + "','" + sc + "','" + ea + "')";
            c.s.executeUpdate(query);
            c.s.executeUpdate(query1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
