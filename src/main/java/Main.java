import nba.EstadisticasEntity;
import nba.HibernateUtil;
import nba.JugadoresEntity;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(final String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<JugadoresEntity> jugadoresEntityList=new ArrayList<JugadoresEntity>();

        int opcion=1;
        while(opcion!=0) {
            menu();
            opcion =in.nextInt();
            switch (opcion){
                case 0:
                    System.out.println("Deu");
                    HibernateUtil.shutdown();
                    break;
                case 1:
                    //procedencia y posicion Cavaliers
                    jugadoresEntityList = session.createQuery("FROM JugadoresEntity ").list();
                    jugadoresEntityList.stream().filter(jugadoresEntity -> {
                        try {
                            return jugadoresEntity.getNombre_equipo().equals("Cavaliers");
                        }
                        catch (NullPointerException ignore){}
                        return false;

                    }).forEach(System.out::println);
                    break;
                case 2:
                    //num jugadores españoles
                    jugadoresEntityList = session.createQuery("FROM JugadoresEntity ").list();
                    int count=0;
                    try {
                        for (JugadoresEntity j : jugadoresEntityList) {
                            if (j.getProcedencia().equals("Spain")) {
                                count++;
                            }
                        }
                    } catch (NullPointerException ignore){}
                    System.out.println("Hay "+count+" jugadores Españoles.");
                    break;
                case 3:
                    //add jugador
                    session.beginTransaction();

                    // Add new Employee object
                    JugadoresEntity jugadoresEntity = new JugadoresEntity();
                    jugadoresEntity.setCodigo(701);
                    jugadoresEntity.setNombre("Angel");
                    jugadoresEntity.setProcedencia("spain");
                    jugadoresEntity.setAltura("180");
                    jugadoresEntity.setPeso(75);
                    jugadoresEntity.setPosicion("A-B");
                    session.save(jugadoresEntity);

                    session.getTransaction().commit();
                    break;
                case 4:
                    //jugadores temporada 04/05 media >10
                    List<EstadisticasEntity> estadisticasEntities=new ArrayList<EstadisticasEntity>();
                    estadisticasEntities = session.createQuery("FROM EstadisticasEntity ").list();
                    jugadoresEntityList = session.createQuery("FROM JugadoresEntity ").list();
                    for (EstadisticasEntity e:estadisticasEntities) {
                        if (e.getPuntosPorPartido()>10 && e.getTemporada().equals("04/05")){
                            try {
                                System.out.println(session.find(JugadoresEntity.class, e.getJugador()).getNombre());
//                                for (JugadoresEntity j : jugadoresEntityList) {
//                                    if (j.getCodigo()==e.getJugador()) {
//                                        System.out.println(j.getNombre());
//                                    }
//                                }
                            } catch (NullPointerException ignore){}
                        }
                    }
                    break;
            }
        }

    }

    private static void menu() {
        System.out.println("0. Salir." +
                "1. Mostrar procedencia y posición de los jugadores de los Cavaliers.\n" +
                "2. Mostrar número de jugadores españoles.\n" +
                "3. Añadir jugador\n" +
                "4. Mostrar jugadores que en la temporada 04/05 tenían una media de\n" +
                "puntos por partido superior a 10.\n");
    }
}
