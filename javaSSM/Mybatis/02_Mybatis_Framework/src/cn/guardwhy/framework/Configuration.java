package cn.guardwhy.framework;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  解析XML文件：sqlMapConfig.xml, UserMapper.xml
 */
public class Configuration {
    // 1.创建连接池的属性
    private String driver;
    private String url;
    private String username;
    private String password;
    // 2.定义连接池
    private DataSource dataSource;

    // 3.实例化1个空的Map集合:封装其它映射文件的XML信息
    private Map<String, Mapper> mappers = new HashMap<>();

    /**
     * 4.在构造方法中调用方法: loadSqlMapConfig()
     *  调用createDataSource()方法
     */
    public Configuration() {
        try {
            loadSqlMapConfig();
            createDataSource();  //创建数据源
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 5.解析配置文件方法
    private void loadSqlMapConfig() throws DocumentException {
        // 5.1. 从类路径加载/sqlMapConfig.xml配置文件，创建输入流
        InputStream inputStream = Configuration.class.getResourceAsStream("/sqlMapConfig.xml");
        // 5.2. 使用dom4j得到文档对象
        Document document = new SAXReader().read(inputStream);
        // 5.3. 使用XPath读取所有property元素
        List<Node> nodes = document.selectNodes("//property");
        // 5.4. 遍历每个property元素，读取它的name和value属性值
        for(Node node : nodes){
            Element propertyElement = (Element) node;
            // 得到name属性
            String name = propertyElement.attributeValue("name");
            // 得到value属性
            String value = propertyElement.attributeValue("value");

            // 6.判断name的字符串，如果与类中的属性名相同，则赋值到相应属性中
            switch (name){
                case "driver":
                    this.driver = value;
                    break;
                case "url":
                    this.url = value;
                    break;
                case "username":
                    this.username = value;
                    break;
                case "password":
                    this.password = value;
                    break;
            }
        }
        // 解析UserMapper.xml文件
        loadMapper(document);
    }

    /**
     * 解析xml实体类映射文件
     * @param document
     */
    private void loadMapper(Document document) throws DocumentException{
        // 1.读取mapper中的resource属性值
        // 1.1 读取mapper元素
        List<Node> nodes = document.selectNodes("//mapper");
        // 1.2 遍历每个mapper元素
        for (Node node : nodes){
            Element mapperElement = (Element) node;
            // 1.3 读取mapper的resource属性值
            String resource = mapperElement.attributeValue("resource");
            // 2.解析这个XML文件,得到namespace,id,resultType,sql的值

            // 2.1 使用类对象,读取输入流下面的resource.
            InputStream inputStream = Configuration.class.getResourceAsStream("/" + resource);
            // 2.2 创建文档对象
            Document doc = new SAXReader().read(inputStream);
            // 2.3 得到根元素
            Element rootElement = doc.getRootElement();
            // 2.4 得到namespace属性
            String namespace = rootElement.attributeValue("namespace");
            // 2.5 读取根元素下的一个select标签
            Element selectElement = rootElement.element("select");
            // 2.6 得到id属性
            String id = selectElement.attributeValue("id");
            // 2.7 resultType属性
            String resultType = selectElement.attributeValue("resultType");
            // 2.8 SQL属性
            String sql = selectElement.getTextTrim();

            // 3.封装成Mapper对象
            // 3.1 创建一个自定义的Mapper对象,封装上面的三个属性
            Mapper mapper = new Mapper();
            mapper.setId(id);
            mapper.setResultType(resultType);
            mapper.setSql(sql);
            // 3.2 再封装namespace属性
            mapper.setNamespace(namespace);
            // 3.3 将封装好的mapper对象添加到this的mappers属性中,其中键是namespace+"."+id,值是自定义的mapper对象。
            String key = namespace + "." + id;
            this.mappers.put(key, mapper);
        }

    }

    /**
     创建数据源
     */
    private void createDataSource() throws PropertyVetoException {
        //使用c3p0连接池
        ComboPooledDataSource ds = new ComboPooledDataSource();
        //在代码中设置连接池的属性
        ds.setUser(this.username);
        ds.setPassword(this.password);
        ds.setJdbcUrl(this.url);
        ds.setDriverClass(this.driver);
        //创建好的数据源赋值给成员变量
        this.dataSource = ds;
    }

    /***
     * set.get方法
     * @return
     */
    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers = mappers;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dataSource=" + dataSource +
                ", mappers=" + mappers +
                '}';
    }
}
