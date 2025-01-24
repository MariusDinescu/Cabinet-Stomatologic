This application manages a dental clinic and allows the administration of users of three types: doctor, administrator, and patient. Depending on the user type, a set of attributes is defined for each, such as username, password, and specific information for each user type (e.g., Covid declaration for patients and specialization for doctors).

The application reads users from a given text file and creates three separate lists of valid users for each of the three user types mentioned. It displays the length of each list, the first and last element from each list, and checks if the users in each list are unique.

Additionally, the application creates a list of all valid users and provides methods to check whether all patients have the same doctor, fto determine how many patients were diagnosed with Covid in February 2020, and to verify how many doctors in the list have the word "cardiologist" in their specialization. The list of administrators is sorted by username.

The application also allows adding a new patient to the patient list if the patient is valid and does not already exist in the list. Finally, it calculates the percentage of patients who had Covid and creates a list of unique elements in the form of pairs like (UserType, OtherCharacteristics) for the first five valid users from the given text file.
