package Main;

import java.util.ArrayList;

/**
 * Класс "База даных"
 */
public class DateBase {

    /**
     * Последний добавленный идентификатор записи
     */
    private int id = 0;
    /**
     * Название базы данных
     */
    private String name;
    /**
     * Массив колонок в таблице
     */
    private ArrayList<Col> cols = new ArrayList<>();
    /**
     * Массив строк в таблице
     */
    private ArrayList<Row> rows = new ArrayList<>();
    /**
     * Вложенный класс "Колонка"
     */
    class Col{

        /**
         * Название колонки
         */
        private String name;
        /**
         * Тип значения в колонке
         */
        private Object type;

        /**
         * Конструктор, присваивающий название колонки
         * @param name Название колонки
         */
        Col(String name){
            this.name = name;
        }
        public Class getType() {
            return type.getClass();
        }
        public  void setType(Object obj) {
            type = obj;
        }

    }

    /**
     * Вложенный класс "Строка" или Запись в таблице
     */
    class Row{

        /**
         * Идентификатор записи
         */
        int id;
        /**
         * Данные соответсвующие столбцам
         */
        private ArrayList<Object> value = new ArrayList<>();

        /**
         * Конструктор, присваивающий идентификатор записи
         * @param id
         */
        Row(int id){
            this.id = id;
        }


        /**
         * Добавление значение в колонку записи
         * @param col индекс колонки
         * @param value значение
         */
        public void addValue(int col, Object value){
            this.value.add(col,value);
        }

        /**
         * Получение значение данных
         * @param col Индекс колонки
         * @param <T>
         * @return
         */
        public  <T> T getValue(int col){
            return (T) this.value.get(col);
        }

    }

    /**
     * Конструктор
     * @param name название базы данных
     */
    DateBase(String name){
        this.name = name;
    }

    /**
     * Поиск записи в строке по колонке, если запись не найдена, то будет возращено -1
     * @param col номер колонки
     * @param value искомое значение
     * @return идентификатор записи
     */
    public int search(int col, Object value) throws DateBaseException{
        if (id > 0) {
            for (int i = 0; i < rows.size(); i++)
                if (rows.get(i).getValue(col).equals(value)) return rows.get(i).id;
        }
        else
            throw new DateBaseException("База данных пуста!");

        return -1;
    }

    /**
     * Добавление колонки в базу данных
     * @param name название колонки
     */
    public void addCol(String name){

        cols.add(new Col(name));
    }

    /**
     * Добавление строки в базу данных
     */
    public void addRow(){
        rows.add(new Row(++id));
    }

    /**
     * Добавление значение в строку
     * @param id идентификатор строки
     * @param col номер колонки
     * @param value значение
     */
    public void addRowValue(int id, int col, Object value){
        int index = -1;

        // Поиск записи
        for (int i = 0; i < rows.size(); i++){
            if (rows.get(i).id == id) {
                index = i;
                break;
            }
        }

        //Если запись не найдена
        if (index == -1){
            System.out.println("Запись не найдена!");
            return;
        }

        //Добавление(Изменение) значения
        rows.get(index).addValue(col,value);

    }

    /**
     * Вывод базы данных в консоль
     */
    public void print(){

        System.out.printf("База данных '%s'\n",name);

        System.out.format("Идентификатор");

        for (int i = 0; i < cols.size(); i++)
            System.out.format("%20s",cols.get(i).name);

        System.out.println();

        for (int i = 0; i < rows.size(); i++){
            System.out.format("%13d",i+1);
            for (int j = 0; j < cols.size(); j++)
                System.out.format("%20s",rows.get(i).getValue(j).toString());
            System.out.println();
        }

        System.out.println();
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }
}