package tables;

import java.util.List;

public interface ITable<T> {
    List<T> list(String[] pred);
}
