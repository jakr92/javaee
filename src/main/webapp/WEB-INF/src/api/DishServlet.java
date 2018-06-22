package api;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import entities.Dish;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "DishServlet", urlPatterns = "/api/dishes")
public class DishServlet extends HttpServlet {


    public DishServlet() throws SQLException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String jsonStr = request.getParameter("json");

        System.out.println(jsonStr);

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Dish dish1 = gson.fromJson(reader,Dish.class);


        String databaseUrl = "jdbc:postgres://ejchljlwiuhyqd:0d6989772b83395f98a4e4f28163dbaaa139aade2ad8f83454467e375bf636cc@ec2-54-247-100-44.eu-west-1.compute.amazonaws.com:5432/d92ue036af10cq";
try {
    ConnectionSource connectionSource =
            new JdbcConnectionSource(databaseUrl);
    Dao<Dish, String> dishDao =
            DaoManager.createDao(connectionSource, Dish.class);
dishDao.create(dish1);
    connectionSource.close();
}catch(Exception e)
{
    System.out.println(e);
}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String databaseUrl = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=postgres";
        try {
            ConnectionSource connectionSource =
                    new JdbcConnectionSource(databaseUrl);
            Dao<Dish, String> dishDao =
                    DaoManager.createDao(connectionSource, Dish.class);
                List<Dish> dishesList = dishDao.queryForAll();
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String json = gson.toJson(dishesList);
            System.out.println(json);
            connectionSource.close();
            PrintWriter out = response.getWriter();
            out.print(json);
            out.flush();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
