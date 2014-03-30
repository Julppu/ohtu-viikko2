
package ohtu.data_access;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ohtu.domain.User;

/**
 * @author julppu
 */

public class FileUserDAO implements UserDao {
    
    private File file;
    private Scanner fileReader;
    private FileWriter fileWriter;
    
    public FileUserDAO(String file) {
        this.file = new File(file);
        try {
            this.fileReader = new Scanner(this.file);
            this.fileWriter = new FileWriter(this.file);
        } catch(FileNotFoundException e) {
            try {
                this.file.createNewFile();
            } catch (IOException ioe) { }
        } catch(IOException ioe) { }
    }

    @Override
    public List<User> listAll() {
        try {
            if (!file.exists())
                file.createNewFile();
            List<User> lista = new ArrayList<User>();
            while(fileReader.hasNext()) {
                String[] naru = fileReader.next().split(" ");
                lista.add(new User(naru[0], naru[1]));
            }
            return lista;
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public User findByName(String name) {
        try {
            if (!file.exists())
                file.createNewFile();
            while (fileReader.hasNext()) {
                String[] naru = fileReader.next().split(" ");
                if (naru[0].equals(name))
                    return new User(naru[0], naru[1]);
            }
        } catch (IOException e) { }
        return null;
    }

    @Override
    public void add(User user) {
        try {
            List list;
            if (!file.exists()) {
                file.createNewFile();
                fileWriter.write(user.getUsername() + " " + user.getPassword() + "\n");
                return;
            }
            else {
                list = this.listAll();
                file.createNewFile();
                list.add(user);
                for (Object listuser: list) {
                    fileWriter.write(user.getUsername() + " " + user.getPassword() + "\n");
                }
            }
        } catch(IOException ioe) { }
    }
}
