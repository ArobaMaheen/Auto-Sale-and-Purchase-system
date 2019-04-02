
package Model;
import Model.*;
import Controller.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
/**
 *
 * @author MAHNOORAFREEN
 */
public class CommisionModel {
    connection c = new connection ();
    connection c2=new connection ();
    connection c3= new connection();
    public void ini1()
    {
        try {
            c.connect();
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Commission where type='informer' AND status='Not Paid' and d='n'");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public Boolean whileMethod()
    {
        Boolean b=false;
        try
        {
        b = c.rs.next();
    }
        catch(Exception e )
        {
            e.printStackTrace();
        }
    return b;
}
    public String[] withinWhile(String mname,String cname,String arr[])
    {      //String arr[]=new String[2];
        try {
                 c.connect();
               
                 System.out.println("Current  :  "+c.rs.getString("ID"));
                    if(c.rs.getString("type").equals("agent")){
                          c2.connect();
                    c2.st=c2.con.createStatement();
                    c2.rs=c2.st.executeQuery("Select * from agents where id='"+c.rs.getString("ID")+"'");
                    c2.rs.next();
                    mname=c2.rs.getString("name");
                    arr[0]=mname;
                }else  if(c.rs.getString("type").equals("informer")){
                   c2.connect();
                    c2.st=c2.con.createStatement();
                    c2.rs=c2.st.executeQuery("Select * from Informers where id='"+c.rs.getString("ID")+"'");
                    c2.rs.next();
                    mname=c2.rs.getString("name");
                    arr[0]=mname;
                }
                    c3.connect();
                c3.st=c3.con.createStatement();
                    c3.rs=c3.st.executeQuery("Select * from Car where id='"+c.rs.getString("carID")+"'");
                    c3.rs.next();
                    cname=c3.rs.getString("name");
                    arr[1]=cname;
                    CheckBox cb=new CheckBox();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return arr;
    }
    public void withinwhile2(String a,String b,String cc)
    {
                                  
    try{
        c.connect();
     c.st=c.con.createStatement();
     c.st.executeUpdate("UPDATE Commission SET status='Paid' WHERE date='"+a+"' AND commission='"+b+"' AND carID='"+cc+"'" );
    System.out.println("Done Updating");
        }
    catch(Exception e )
    {
    e.printStackTrace();
                             }
    }

    public void withinWhile3(ObservableList ol ,String mname ,String cname,CheckBox cb)
    {
        try{
            c.connect();
ol.add(new tablecomm(mname, cname, c.rs.getString("commission"), c.rs.getString("date"), c.rs.getString("Status"),c.rs.getString("carID"),cb));

    }
        catch(Exception e )
        {
            e.printStackTrace();
        }
        
    }
    public void ddd1()
    {
        try
        {
            c.connect();
             c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Commission where type='informer' AND status='Paid' and d='n'");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public boolean whil1()
    {
        c.connect();
        boolean b = false;
        try{
        b=c.rs.next();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return b;
        
    }
    
    public void insideWhile(ComboBox cb){
        try {
            cb.getItems().add(c.rs.getString("id")+"  "+c.rs.getString("name"));
        } catch (SQLException ex) {
            Logger.getLogger(CommisionModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String[] ddd2(String mname,String cname,ObservableList ol,String arr[])
    {
        try{
                            if(c.rs.getString("type").equals("agent")){
                                c.connect();
                    c2.st=c2.con.createStatement();
                    c2.rs=c2.st.executeQuery("Select * from agents where id='"+c.rs.getString("ID")+"'");
                    c2.rs.next();
                    mname=c2.rs.getString("name");
                    arr[0]=mname;
                }else  if(c.rs.getString("type").equals("informer")){
                    c2.connect();
                    c2.st=c2.con.createStatement();
                    c2.rs=c2.st.executeQuery("Select * from Informers where id='"+c.rs.getString("ID")+"'");
                    c2.rs.next();
                    mname=c2.rs.getString("name");
                    arr[0]=mname;
                }
                            c3.connect();
                c3.st=c3.con.createStatement();
                    c3.rs=c3.st.executeQuery("Select * from Car where id='"+c.rs.getString("carID")+"'");
                    c3.rs.next();
                    cname=c3.rs.getString("name");
                    arr[1]=cname;
            
ol.add(new tablecomm(mname, cname, c.rs.getString("commission"), c.rs.getString("date"), c.rs.getString("Status"),c.rs.getString("carID"),new Button("Generate Invoice")));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return arr;
    }
    public void ddd3()
            
    {
        try
        {
            c.connect();
             c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Commission where type='agent' and status='Paid' and d='n'");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public String[] ddd4(String mname,String cname,ObservableList ol,String arr[])
    {
        try{
            c.connect();
                            if(c.rs.getString("type").equals("agent")){
                     c2.connect();
                    c2.st=c2.con.createStatement();
                    c2.rs=c2.st.executeQuery("Select * from agents where id='"+c.rs.getString("ID")+"'");
                    c2.rs.next();
                    mname=c2.rs.getString("name");
                    arr[0]=mname;
                    
                }else  if(c.rs.getString("type").equals("informer")){
                    c2.connect();
                    c2.st=c2.con.createStatement();
                    c2.rs=c2.st.executeQuery("Select * from Informers where id='"+c.rs.getString("ID")+"'");
                    c2.rs.next();
                    mname=c2.rs.getString("name");
                    arr[0]=mname;
                }
                            c3.connect();
                c3.st=c3.con.createStatement();
                    c3.rs=c3.st.executeQuery("Select * from Car where id='"+c.rs.getString("carID")+"'");
                    c3.rs.next();
                    cname=c3.rs.getString("name");
                    arr[1]=cname;
                    
ol.add(new tablecomm(mname, cname, c.rs.getString("commission"), c.rs.getString("date"), c.rs.getString("Status"),c.rs.getString("carID"),new Button("Generate Invoice")));
        }
        catch(Exception e)
            
        {
            e.printStackTrace();
        }
        return arr;
    }
    public void ddd5()
    {
        try
        {
            c.connect();
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Commission where type='informer' AND status='Not Paid' and d='n'");
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public String[] ddd6(String mname,String cname,String arr[])
    {
        try{
            c.connect();
                if(c.rs.getString("type").equals("agent")){
                    c2.connect();
                    c2.st=c2.con.createStatement();
                    c2.rs=c2.st.executeQuery("Select * from agents where id='"+c.rs.getString("ID")+"'");
                    c2.rs.next();
                    mname=c2.rs.getString("name");
                    arr[0]=mname;
                }else  if(c.rs.getString("type").equals("informer")){
                    c2.connect();
                    c2.st=c2.con.createStatement();
                    c2.rs=c2.st.executeQuery("Select * from Informers where id='"+c.rs.getString("ID")+"'");
                    c2.rs.next();
                    mname=c2.rs.getString("name");
                     arr[0]=mname;
                }
                 c3.connect();
                c3.st=c3.con.createStatement();
                    c3.rs=c3.st.executeQuery("Select * from Car where id='"+c.rs.getString("carID")+"'");
                    c3.rs.next();
                    cname=c3.rs.getString("name");
                     arr[1]=cname;
                     //start
        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return arr;
    }
    public void ddd7(String a , String b ,String cc)
            
    {
        try
        {
            c.connect();
            c.st=c.con.createStatement();
            c.st.executeUpdate("UPDATE Commission SET status='Paid' WHERE date='"+a+"' AND commission='"+b+"' AND carID='"+cc+"'" );
            System.out.println("Done Updating");
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
    }
    public void ddd8(ObservableList ol,String mname ,String cname, CheckBox cb)
    {
        try
            
        {
            c.connect();
            ol.add(new tablecomm(mname, cname, c.rs.getString("commission"), c.rs.getString("date"), c.rs.getString("Status"),c.rs.getString("carID"),cb));
        }
        catch (Exception e)
        {
           e.printStackTrace();
        }
    }
    public void ddd9()
    {
        try{
            c.connect();
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Commission where type='agent' AND status='Not Paid' and d='n'");
        }
        catch(Exception e)
        {
            e.getStackTrace();
        }
    }
    public String[] ddd10(String mname,String cname,String arr[])
    {
        try
        {
            c.connect();
            c2.connect();
            c3.connect();
                    
            if(c.rs.getString("type").equals("agent")){
                    c2.connect();
                    c2.st=c2.con.createStatement();
                    c2.rs=c2.st.executeQuery("Select * from agents where id='"+c.rs.getString("ID")+"'");
                    c2.rs.next();
                    mname=c2.rs.getString("name");
                    arr[0]=mname;
                }else  if(c.rs.getString("type").equals("informer")){
                    c2.connect();
                    c2.st=c2.con.createStatement();
                    c2.rs=c2.st.executeQuery("Select * from Informers where id='"+c.rs.getString("ID")+"'");
                    c2.rs.next();
                    mname=c2.rs.getString("name");
                    arr[0]=mname;
                }
               c3.connect();
                c3.st=c3.con.createStatement();
                    c3.rs=c3.st.executeQuery("Select * from Car where id='"+c.rs.getString("carID")+"'");
                    c3.rs.next();
                    cname=c3.rs.getString("name");
                    arr[1]=cname;
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
        return arr;
    }
    public void ddd11(String a , String b , String cc)
    {
        try{ c.connect();
             c.st=c.con.createStatement();
                                 c.st.executeUpdate("UPDATE Commission SET status='Paid' WHERE date='"+a+"' AND commission='"+b+"' AND carID='"+cc+"'" );
                                 System.out.println("Done Updating");
        }
        catch(Exception e)
        {
           e.printStackTrace();
    }
            
}
    public void ddd12(  ObservableList<tablecomm>  ol,String mname ,String cname ,CheckBox cb)
    {
        try
        {
           c.connect();
        ol.add(new tablecomm(mname, cname, c.rs.getString("commission"), c.rs.getString("date"), c.rs.getString("Status"),c.rs.getString("carID"),cb));

        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
    }
    public void adw1()
    {
        try
        {
            c.connect();
             c.st=c.con.createStatement();
                c.rs=c.st.executeQuery("Select * from Agents");
          }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void adw2()
    {
        try
        { 
            c.connect();
            c.st=c.con.createStatement();
                c.rs=c.st.executeQuery("Select * from Informers");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void adw3( ComboBox<String> cb2)
    {
        try
        {
            c.connect();
                while(c.rs.next()){
                    cb2.getItems().add(c.rs.getString("id")+"  "+c.rs.getString("name"));
                    
                }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
    }
    public void adw4( FlowPane hb, ComboBox<String> cb3)
    {
                 try{
                     c.connect();
                c.st=c.con.createStatement();
                c.rs=c.st.executeQuery("Select * from Car WHERE d='n'");
                
                while(c.rs.next()){
                    cb3.getItems().add(c.rs.getString("ID")+" "+c.rs.getString("name"));
                    
                }
                hb.getChildren().add(cb3);
            }catch(Exception ex){
                ex.printStackTrace();
            }
    }
    public void adw5(  String id,ComboBox<String> cb,String car , String com,  String dat)
    {
        try
        {
            c.connect();
             c.st=c.con.createStatement();
        c.st.executeUpdate("INSERT INTO Commission values('"+id+"','"+cb.getValue().toLowerCase()+"','"+car+"','"+com+"','Not Paid','"+dat+"','n')");
        }
        catch(Exception e)
        {
         e.printStackTrace();
        }
    }
    public void del(tablecomm tcc)
    {
        try
        {
            c.connect();
            c.st=c.con.createStatement();
        // String.format("UPDATE Commission SET d='y' WHERE carID='%s', commission='%s', date='%s', d='n'", tcc.carid,tcc.comm,tcc.date);
           
         c.st.executeUpdate(String.format("UPDATE Commission SET d='y' WHERE carID='%s' and commission='%s' and date='%s' and d='n'", tcc.carid,tcc.comm,tcc.date));
        }
        catch(Exception e)
            
        {
            e.printStackTrace();
        }
    }
    
}
