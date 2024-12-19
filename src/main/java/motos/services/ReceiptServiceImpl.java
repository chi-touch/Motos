//package motos.services;
//
//import motos.models.Passenger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ReceiptServiceImpl implements ReceiptService{
//
//    @Autowired
//    private MailSender mailSender;
//    public void sendReceipt(Passenger passenger){
//        String receiptContent = generateReceipt(passenger);
//
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(passenger.getEmail());
//        message.setSubject("Bus Booking Receipt");
//        message.setText(receiptContent);
//        mailSender.send(message);
//    }
//}
