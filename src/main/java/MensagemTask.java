

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


/**
 * IF62C Fundamentos de Programação 2 Exemplo de programação em Java. Tarefa que
 * exibe a hora atual na saída padrão.
 *
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
public class MensagemTask extends TimerTask {

    private final Date currentTime = new Date();
    private final SimpleDateFormat sdf = new SimpleDateFormat("'Hora:' HH:mm:ss");
    ImparTask i = new ImparTask();
public  void fecha(){
i.cancel();
}
    @Override
    public void run() {
        currentTime.setTime(System.currentTimeMillis());
        System.out.println(sdf.format(currentTime));
        Timer t1 = new Timer();
        if ((currentTime.getTime() % 120000) >= 60000) {
            
            i= new ImparTask();
            t1.scheduleAtFixedRate(i, 10000, 10000);

        } else {
            if (i != null) {
                i.cancel();
            }
        }
    }
}
