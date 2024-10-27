import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        //Проверить логин и пароль

        //Вызвать методы валидации пользователя

        try {
            // Find user by login and password
            User user = getUserByLoginAndPassword(login, password);

            // Validate user access rights
            validateUser(user);

            System.out.println("Доступ предоставлен");
        } catch (UserNotFoundException | AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static User[] getUsers() {
        User user1 = new User("jhon", "jhon@gmail.com", "pass", 24);
        User user2 = new User("sam", "admin1", "sam@sm.com", 12);

        return new User[]{user1, user2};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new UserNotFoundException("Пользователь не найден");
    }

    public static void validateUser(User user) throws AccessDeniedException{
        if (user.getAge() < 18) {
            throw new AccessDeniedException("Доступ закрыт, возрост ниже 18.");
        }
    }

}
