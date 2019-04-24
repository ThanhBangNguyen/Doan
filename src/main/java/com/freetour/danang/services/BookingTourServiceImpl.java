package com.freetour.danang.services;

import com.freetour.danang.dao.models.BookingTour;
import com.freetour.danang.dao.repositories.BookingTourRepository;
import com.freetour.danang.dto.BookingTourDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.ArrayList;
import java.util.List;


@Service
public class BookingTourServiceImpl implements BookingTourService {
    @Autowired
    BookingTourRepository bookingTourRepository;
    @Autowired
    JavaMailSender javaMailSender;
    @Override
    public void bookingTour(BookingTourDTO bookingTourDTO) {

        BookingTour bookingTour = new BookingTour();
        bookingTour.setGmail(bookingTourDTO.getGmail());
        bookingTour.setName(bookingTourDTO.getName()    );
        bookingTour.setCountPeople(bookingTourDTO.getCountPeople());
        bookingTour.setDateJoin(bookingTourDTO.getDateJoin());
        bookingTour.setTimeTour(bookingTourDTO.getTimeTour());
        bookingTour.setLanguage(bookingTourDTO.getLanguage());
        bookingTour.setYesEnglish(bookingTourDTO.getYesEnglish());
        bookingTour.setFoodyStory(bookingTourDTO.getFoodyStory());
        bookingTour.setReasonNotfoody(bookingTourDTO.getReasonNotfoody());
        bookingTour.setCity(bookingTourDTO.getCity());
        bookingTour.setHowKnowUs(bookingTourDTO.getHowKnowUs());
        bookingTour.setContact(bookingTourDTO.getContact());
        bookingTour.setDateLeave(bookingTourDTO.getDateLeave());
        bookingTour.setCheckOut(bookingTourDTO.getCheckOut());
        bookingTour.setOtherEmail(bookingTourDTO.getOtherEmail());
        bookingTour.setQuestion(bookingTourDTO.getQuestion());
        bookingTourRepository.save(bookingTour);
        try {

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setTo(bookingTourDTO.getGmail());
            Multipart multipart = new MimeMultipart();
            BodyPart messageBodyPart = new MimeBodyPart();
            //----------------------- Text---------------------
            messageBodyPart.setText("\nHi: " + bookingTourDTO.getName() +

                        "\nYour Email: " + bookingTourDTO.getGmail() +
                        "\nYour City: " + bookingTourDTO.getCity() +
                        "\nPeople Join DaNangFreeWalkingTour: " + bookingTourDTO.getCountPeople() +
                        "\nDate Join Tour: " + bookingTourDTO.getDateJoin() +
                        "\nTimeTour: " + bookingTourDTO.getTimeTour() +
                        "\nLanguage: " + bookingTourDTO.getLanguage() +
                        "\nIf our Chinese and Korean guides are busy, can you join us in English Speaking Tour? :" + bookingTourDTO.getYesEnglish() +
                        "\nTry delicious local foods, and learn about history, culture of Vietnamese in the past?  " + bookingTourDTO.getFoodyStory() +
                        "\nf no, can you tell us the reasons why you don't want to join Foody Story Tour? " + bookingTourDTO.getReasonNotfoody() +
                        "\nHow do you know us : " + bookingTourDTO.getHowKnowUs() +
                        "\nFacebook Messenger link, phone, email: " + bookingTourDTO.getContact() +
                        "\nWhen do you leave Da Nang ? :" + bookingTourDTO.getDateLeave() +
                        "\nCheck out example videos from CGTN [CCTV] on our Tours: " + bookingTourDTO.getCheckOut() +
                        "\nAsk us any travel related questions and get the local to answer  :" + bookingTourDTO.getQuestion() +
                        "\nA confirmation email will be sent with meeting details. Anything else we can assist you to make your visit to Da Nang better?:  " + bookingTourDTO.getOtherEmail() +

                        "\n Thank you for reading the email! "
            );
            multipart.addBodyPart(messageBodyPart);
            helper.setSubject("Da Nang Free Walking Tour");
            message.setContent(multipart);
            javaMailSender.send(message);


        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Send emmail failed !");
        }

    }

    @Override
    public List<BookingTourDTO> listTours() {
        List<BookingTourDTO> bookingTourDTOS = new ArrayList<>();
        List<BookingTour> bookingTours = bookingTourRepository.findAll();
        for (BookingTour  bookingTour :bookingTours){
            BookingTourDTO bookingTourDTO = new BookingTourDTO();
            bookingTourDTO.setId(bookingTour.getId());
            bookingTourDTO.setGmail(bookingTour.getGmail());
            bookingTourDTO.setName(bookingTour.getName());
            bookingTourDTO.setCountPeople(bookingTour.getCountPeople());
            bookingTourDTO.setDateJoin(bookingTour.getDateJoin());
            bookingTourDTO.setDateLeave(bookingTour.getDateLeave());
            bookingTourDTO.setTimeTour(bookingTour.getTimeTour());
            bookingTourDTO.setLanguage(bookingTour.getLanguage());
            bookingTourDTO.setYesEnglish(bookingTour.getYesEnglish());
            bookingTourDTO.setFoodyStory(bookingTour.getFoodyStory());
            bookingTourDTO.setReasonNotfoody(bookingTour.getReasonNotfoody());
            bookingTourDTO.setCity(bookingTour.getCity());
            bookingTourDTO.setHowKnowUs(bookingTour.getHowKnowUs());
            bookingTourDTO.setContact(bookingTour.getContact());
            bookingTourDTO.setCheckOut(bookingTour.getCheckOut());
            bookingTourDTO.setOtherEmail(bookingTour.getOtherEmail());
            bookingTourDTO.setQuestion(bookingTour.getQuestion());
            bookingTourDTOS.add(bookingTourDTO);
        }
        return bookingTourDTOS;
    }

    @Override
    public void deleteTour(Long id) {
        bookingTourRepository.deleteById(id);

    }

    @Override
    public BookingTourDTO detailTour(Long id) {
        BookingTour bookingTour = bookingTourRepository.findBookingTour(id);
        BookingTourDTO bookingTourDTO = new BookingTourDTO();

        bookingTourDTO.setId(bookingTour.getId());
        bookingTourDTO.setGmail(bookingTour.getGmail());
        bookingTourDTO.setName(bookingTour.getName());
        bookingTourDTO.setCountPeople(bookingTour.getCountPeople());
        bookingTourDTO.setDateJoin(bookingTour.getDateJoin());
        bookingTourDTO.setDateLeave(bookingTour.getDateLeave());
        bookingTourDTO.setTimeTour(bookingTour.getTimeTour());
        bookingTourDTO.setLanguage(bookingTour.getLanguage());
        bookingTourDTO.setYesEnglish(bookingTour.getYesEnglish());
        bookingTourDTO.setFoodyStory(bookingTour.getFoodyStory());
        bookingTourDTO.setReasonNotfoody(bookingTour.getReasonNotfoody());
        bookingTourDTO.setCity(bookingTour.getCity());
        bookingTourDTO.setHowKnowUs(bookingTour.getHowKnowUs());
        bookingTourDTO.setContact(bookingTour.getContact());
        bookingTourDTO.setCheckOut(bookingTour.getCheckOut());
        bookingTourDTO.setOtherEmail(bookingTour.getOtherEmail());
        bookingTourDTO.setQuestion(bookingTour.getQuestion());

        return bookingTourDTO;
    }
}
