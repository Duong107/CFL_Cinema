package com.GUI.form.SuKien;

import DAO.KHTTDAO;
import DAO.KhuyenMaiDAO;
import DAO.PhimDAO;
import Entity.KHTT;
import Entity.KhuyenMai;
import Entity.Phim;
import Utilities.Auth;
import Utilities.ValidateCheck;
import Utilities.XDate;
import com.GUI.form.BanVe.BanVe_Form;
import com.GUI.main.Main;
import com.GUI.swing.ScrollBar;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SKDangDienRa_Form extends javax.swing.JPanel {

    private DefaultTableModel modeltable;
    private List<KhuyenMai> list;
    private ValidateCheck vld = new ValidateCheck();
    private KhuyenMaiDAO KmAction;
    static SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
    int i = -1;
    public static boolean xoa_SKDangDR = false;
    public static String MaSuKiDDR;

    public SKDangDienRa_Form() {
        initComponents();
        setOpaque(false);
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        FillTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        btndelete = new com.GUI.swing.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblsukien = new com.GUI.swing.Table();
        btnGuiMail = new com.GUI.swing.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("S??? KI???N ??ANG DI???N RA");

        btndelete.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setText("X??A");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        tblsukien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "M?? KM", "T??n Khuy???n M??i", "M???c Gi???m Gi??", "Ng??y B???t ?????u", "Ng??y K???t Th??c", "M?? Nh??n Vi??n"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblsukien);

        btnGuiMail.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnGuiMail.setForeground(new java.awt.Color(255, 255, 255));
        btnGuiMail.setText("G???i mail");
        btnGuiMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuiMailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(499, 499, 499))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuiMail, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1409, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuiMail, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        if (Auth.isManager()) {
            int i = JOptionPane.showConfirmDialog(this, "B???n c?? ch???c mu???n xo?? s??? ki???n n??y?");
        if (i == 0) {
            if (tblsukien.getRowCount() > 0) {
                DeleteValues();
                Main.banVe = new BanVe_Form();
            } else {
                JOptionPane.showMessageDialog(null, "Ch??a C?? D??? Li???u!");
            }
        }
        } else {
            JOptionPane.showMessageDialog(null, "Ch??? Qu???n l?? m???i ???????c s??? d???ng ch???c n??ng n??y.");
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnGuiMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuiMailActionPerformed
        i = tblsukien.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(null, "Vui l??ng ch???n s??? ki???n c???n g???i mail");
            return;
        } else {
            KhuyenMai km = new KhuyenMaiDAO().selectById(tblsukien.getValueAt(i, 0).toString());
            guiMail2(km);
        }
    }//GEN-LAST:event_btnGuiMailActionPerformed

    private void btnSendMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelete1ActionPerformed
        try {
            guiMail();
        } catch (MessagingException ex) {
            Logger.getLogger(SKDangDienRa_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btndelete1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.GUI.swing.Button btnGuiMail;
    private com.GUI.swing.Button btndelete;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private com.GUI.swing.Table tblsukien;
    // End of variables declaration//GEN-END:variables

    private void FillTable() {
        list = null;
        list = new KhuyenMaiDAO().selectallbydate();
        modeltable = (DefaultTableModel) tblsukien.getModel();
        modeltable.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            modeltable.addRow(new Object[]{list.get(i).getMaKM(), list.get(i).getTenKM(), list.get(i).getMucGiamGia(), list.get(i).getNgayBatDau(), list.get(i).getNgayKetThuc(), list.get(i).getMaNhanVien()});
        }
        modeltable.fireTableDataChanged();
    }

    private void DeleteValues() {
        int index = tblsukien.getSelectedRow();
        if (index != -1) {
            xoa_SKDangDR = true;
            MaSuKiDDR = tblsukien.getValueAt(index, 0).toString();
            Main.saoLuu.logSuKien();
            KmAction = new KhuyenMaiDAO();
            KmAction.delete(tblsukien.getValueAt(index, 0).toString());
            JOptionPane.showMessageDialog(null, "X??a D??? Li???u Th??nh C??ng!");
            FillTable();
            return;
        }
        JOptionPane.showMessageDialog(null, "X??a D??? Li???u Kh??ng Th??nh C??ng!");
    }

    private void guiMail() throws AddressException, MessagingException {
        List<KHTT> listMailKH = new KHTTDAO().selectAll();
        Properties p = new Properties();
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", 587);
        String accountName = "cflcinema.nhom02@gmail.com";
        String accountPassword = "CFLnhom02";
        Session s = Session.getInstance(p, new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(accountName, accountPassword);
            }
        });
        String from = accountName;
        // g???i ?????n mail n??o       
        for (int j = 0; j < listMailKH.size(); j++) {
            String email = listMailKH.get(j).getEmail();
            String nameKH = listMailKH.get(j).getTen();

            // ch??? ?????
            Thread a = new Thread() {
                @Override
                public void run() {
                    try {
                        String subject = "CFL Cinema";
                        // n???i dung
                        String body = "<!DOCTYPE html>\n"
                                + "<html lang=\"en\">\n"
                                + "<head>\n"
                                + "    <meta charset=\"UTF-8\">\n"
                                + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                                + "    <title>Document</title>\n"
                                + "</head>\n"
                                + "<body>\n"
                                + "    <div class = \"bocNgoai\" >\n"
                                + "        <h1 style = \"text-align: center;color: #B22222;\">CFL Cinema</h1>\n"
                                + "\n"
                                + "        <div class =\"bocTrong\" style=\"margin: 0 auto;width: 390px; height: 350px;border: 5px outset gray;padding: 15px;\">\n"
                                + "            <p  style=\"font-size: 18px\">\n"
                                + "                <span>Xin ch??o </span><b>" + nameKH + "</b>\n"
                                + "                <br><br>\n"
                                + "                <p style=\"\"> C??ng ty TNHH CFL Cinema tr??n tr???ng th??ng b??o. C???m ??n Qu?? kh??ch ???? c??ng tin t?????ng, ?????ng h??nh v?? b??nh ch???n \n"
                                + "                  CFL Cinema l?? c??ng ty d???n ?????u v??? tr???i nghi???m kh??ch h??ng r???p chi???u phim. \n"
                                + "                  Nay ch??ng t??i t??? ch???c s??? ki???n tri ??n kh??ch h??ng. K??nh mong qu?? kh??ch\n"
                                + "                  c?? m???t t???i bu???i tri ??n \n"
                                + "                  <ul>\n"
                                + "                      <li><b>T??n s??? ki???n: ??n m???ng gi??m ?????c Nguy??n qua m??n</b></li>\n"
                                + "                      <li><b>Th???i gian: 19:00 PM 30/02/2021</b></li>\n"
                                + "                      <li><b>Gi???m gi??: 90%</b></li>\n"
                                + "                      \n"
                                + "                  </ul>\n"
                                + "                  Ch??ng t??i mong nh???n ???????c s??? ph???n h???i s???m t??? Qu?? kh??ch ! <br><br>\n"
                                + "                  Gi??m ?????c: <b>????o ?????c Nguy??n</b>\n"
                                + "                </p>\n"
                                + "                </p>\n"
                                + "\n"
                                + "        </div>\n"
                                + "\n"
                                + "\n"
                                + "\n"
                                + "    </div>\n"
                                + "</body>\n"
                                + "</html>";
                        Message msg = new MimeMessage(s);
                        msg.setFrom(new InternetAddress(from));
                        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                        msg.setSubject(subject);
                        msg.setContent(body, "text/html;charset = utf-8");

                        Transport.send(msg);
                    } catch (AddressException ex) {
                        Logger.getLogger(SKDangDienRa_Form.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (MessagingException ex) {
                        Logger.getLogger(SKDangDienRa_Form.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            a.start();
        }
        JOptionPane.showMessageDialog(null, "G???i mail th??nh c??ng");
    }

    public void guiMail2(KhuyenMai khuyenMai) {
        List<KHTT> listMailKH = new KHTTDAO().selectAll();
        List<Phim> listPhim = new PhimDAO().selectAll();
        Properties p = new Properties();
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", 587);
        String accountName = "cflcinema.nhom02@gmail.com";
        String accountPassword = "CFLnhom02";
        Session s = Session.getInstance(p, new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(accountName, accountPassword);
            }
        });
        String from = accountName;
        // g???i ?????n mail n??o       

        String tenSK = khuyenMai.getTenKM();
        String thoiGianKetThucSK = XDate.toString(khuyenMai.getNgayKetThuc());
        String phanTramGiam = String.valueOf(khuyenMai.getMucGiamGia());
        for (int i = 0; i < listMailKH.size(); i++) {
            // ch??? ?????
            String email = listMailKH.get(i).getEmail();
            String tenKH = listMailKH.get(i).getTen();

            Thread a = new Thread() {
                @Override
                public void run() {
                    try {
                        String subject = "CFL Cinema";
                        // n???i dung

                        Message msg = new MimeMessage(s);
                        msg.setFrom(new InternetAddress(from));
                        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                        msg.setSubject(subject);
                        // t???o html mime part
                        MimeBodyPart messageBodyPart = new MimeBodyPart();
                        messageBodyPart.setContent(htmlForMail(tenKH, tenSK, thoiGianKetThucSK, phanTramGiam, listPhim), "text/html;charset = utf-8");
                        // t???o mutil part
                        Multipart multipart = new MimeMultipart();
                        multipart.addBodyPart(messageBodyPart);
                        // t???o m???ng key v?? values 

                        // ?????y t???ng ph???n t??? map + d?????ng d???n file v??o trong t???ng ph???n c???a message
                        Map<String, String> map = mapImage(listPhim);
                        Set<String> set = map.keySet();
                        for (String s : set) {
                            MimeBodyPart imagePart = new MimeBodyPart();
                            imagePart.setHeader("Content-ID", "<" + s + ">");
                            imagePart.setDisposition(MimeBodyPart.INLINE);
                            try {
                                imagePart.attachFile(new File(map.get(s)).getAbsolutePath());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            multipart.addBodyPart(imagePart);
                        }
                        msg.setContent(multipart);
                        Transport.send(msg);
                    } catch (AddressException ex) {
                        Logger.getLogger(SKDangDienRa_Form.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (MessagingException ex) {
                        Logger.getLogger(SKDangDienRa_Form.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            a.start();
        }
        JOptionPane.showMessageDialog(null, "G???i mail th??nh c??ng");
    }

    public String htmlForMail(String tenKhachHang, String tenSuKien, String thoiGianKetThucSK, String phanTramGiam, List<Phim> listPhim) {
        String html = "<!DOCTYPE html>\n"
                + "\n"
                + "<html lang=\"en\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:v=\"urn:schemas-microsoft-com:vml\">\n"
                + "\n"
                + "<head>\n"
                + "	<title></title>\n"
                + "	<meta charset=\"utf-8\" />\n"
                + "	<meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\" />\n"
                + "	<!--[if mso]><xml><o:OfficeDocumentSettings><o:PixelsPerInch>96</o:PixelsPerInch><o:AllowPNG/></o:OfficeDocumentSettings></xml><![endif]-->\n"
                + "	<!--[if !mso]><!-->\n"
                + "	<link href=\"https://fonts.googleapis.com/css?family=Bitter\" rel=\"stylesheet\" type=\"text/css\" />\n"
                + "	<!--<![endif]-->\n"
                + "	<style>\n"
                + "		* {\n"
                + "			box-sizing: border-box;\n"
                + "		}\n"
                + "\n"
                + "		body {\n"
                + "			margin: 0;\n"
                + "			padding: 0;\n"
                + "		}\n"
                + "\n"
                + "		a[x-apple-data-detectors] {\n"
                + "			color: inherit !important;\n"
                + "			text-decoration: inherit !important;\n"
                + "		}\n"
                + "\n"
                + "		#MessageViewBody a {\n"
                + "			color: inherit;\n"
                + "			text-decoration: none;\n"
                + "		}\n"
                + "\n"
                + "		p {\n"
                + "			line-height: inherit\n"
                + "		}\n"
                + "\n"
                + "		@media (max-width:660px) {\n"
                + "			.icons-inner {\n"
                + "				text-align: center;\n"
                + "			}\n"
                + "\n"
                + "			.icons-inner td {\n"
                + "				margin: 0 auto;\n"
                + "			}\n"
                + "\n"
                + "			.fullMobileWidth,\n"
                + "			.row-content {\n"
                + "				width: 100% !important;\n"
                + "			}\n"
                + "\n"
                + "			.image_block img.big {\n"
                + "				width: auto !important;\n"
                + "			}\n"
                + "\n"
                + "			.stack .column {\n"
                + "				width: 100%;\n"
                + "				display: block;\n"
                + "			}\n"
                + "\n"
                + "			.reverse {\n"
                + "				display: table;\n"
                + "				width: 100%;\n"
                + "			}\n"
                + "\n"
                + "			.reverse .column.first {\n"
                + "				display: table-footer-group !important;\n"
                + "			}\n"
                + "\n"
                + "			.reverse .column.last {\n"
                + "				display: table-header-group !important;\n"
                + "			}\n"
                + "\n"
                + "			.row-9 th.column.first>table,\n"
                + "			.row-9 th.column.last>table {\n"
                + "				padding-left: 25px;\n"
                + "				padding-right: 25px;\n"
                + "			}\n"
                + "		}\n"
                + "	</style>\n"
                + "</head>\n"
                + "\n"
                + "<body style=\"background-color: #FFFFFF; margin: 0; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\n"
                + "	<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\"\n"
                + "		style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #FFFFFF;\" width=\"100%\">\n"
                + "		<tbody>\n"
                + "			<tr>\n"
                + "				<td>\n"
                + "					<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-1\"\n"
                + "						role=\"presentation\"\n"
                + "						style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff1e0; background-image: url('cid:imgBgHeader'); background-repeat: repeat;\"\n"
                + "						width=\"100%\">\n"
                + "						<tbody>\n"
                + "							<tr>\n"
                + "								<td>\n"
                + "									<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "										class=\"row-content stack\" role=\"presentation\"\n"
                + "										style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 640px;\"\n"
                + "										width=\"640\">\n"
                + "										<tbody>\n"
                + "											<tr>\n"
                + "												<td class=\"column\"\n"
                + "													style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-left: 25px; padding-right: 25px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n"
                + "													width=\"41.666666666666664%\">\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "														class=\"image_block\" role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td\n"
                + "																style=\"padding-top:30px;width:100%;padding-right:0px;padding-left:0px;padding-bottom:25px;\">\n"
                + "																<div align=\"center\" style=\"line-height:10px\">\n"
                + "																	<!-- <img\n"
                + "																		alt=\"Logo\" src=\"images/yourlogo__3_.png\"\n"
                + "																		style=\"display: block; height: auto; border: 0; width: 130px; max-width: 100%;\"\n"
                + "																		title=\"Logo\" width=\"130\" /> -->\n"
                + "																		<strong style = \"text-align: center;color: #B22222;font-size: 35px;\">CFL Cinema</strong>\n"
                + "																</div>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "												</td>\n"
                + "												<td class=\"column\"\n"
                + "													style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-left: 25px; padding-right: 25px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n"
                + "													width=\"58.333333333333336%\">\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"text_block\"\n"
                + "														role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td style=\"padding-top:65px;padding-bottom:25px;\">\n"
                + "																<div style=\"font-family: sans-serif\">\n"
                + "																	<div\n"
                + "																		style=\"font-size: 12px; mso-line-height-alt: 18px; color: #393d47; line-height: 1.5; font-family: Arial, Helvetica Neue, Helvetica, sans-serif;\">\n"
                + "																		<p\n"
                + "																			style=\"margin: 0; font-size: 12px; text-align: left; mso-line-height-alt: 38px;\">\n"
                + "																			<span style=\"font-size:18px;\"><strong>C???m\n"
                + "																					nh???n v?? ??am m?? c??ng CFL \n"
                + "																					</strong></span></p>\n"
                + "																	</div>\n"
                + "																</div>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "												</td>\n"
                + "											</tr>\n"
                + "										</tbody>\n"
                + "									</table>\n"
                + "								</td>\n"
                + "							</tr>\n"
                + "						</tbody>\n"
                + "					</table>\n"
                + "					<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-2\"\n"
                + "						role=\"presentation\"\n"
                + "						style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #383029; background-image: url('cid:imgBgBody1'); background-repeat: repeat;\"\n"
                + "						width=\"100%\">\n"
                + "						<tbody>\n"
                + "							<tr>\n"
                + "								<td>\n"
                + "									<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "										class=\"row-content stack\" role=\"presentation\"\n"
                + "										style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 640px;\"\n"
                + "										width=\"640\">\n"
                + "										<tbody>\n"
                + "											<tr>\n"
                + "												<td class=\"column\"\n"
                + "													style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-left: 25px; padding-right: 25px; padding-top: 60px; padding-bottom: 60px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n"
                + "													width=\"100%\">\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "														class=\"heading_block\" role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td style=\"text-align:center;width:100%;\">\n"
                + "																<h1\n"
                + "																	style=\"margin: 0; color: #ffffff; direction: ltr; font-family: Arial, Helvetica Neue, Helvetica, sans-serif; font-size: 27px; font-weight: normal; letter-spacing: 1px; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\">\n"
                + "																	Xin ch??o: " + tenKhachHang + "</h1>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "														class=\"image_block\" role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td\n"
                + "																style=\"padding-top:5px;width:100%;padding-right:0px;padding-left:0px;\">\n"
                + "																<div align=\"center\" style=\"line-height:10px\"><img\n"
                + "																		src=\"cid:imgGachDuoiTenKhach\"\n"
                + "																		style=\"display: block; height: auto; border: 0; width: 325px; max-width: 100%;\"\n"
                + "																		width=\"325\" /></div>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"text_block\"\n"
                + "														role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td style=\"padding-top:30px;\">\n"
                + "																<div style=\"font-family: sans-serif\">\n"
                + "																	<div\n"
                + "																		style=\"font-size: 14px; mso-line-height-alt: 16.8px; color: #ffffff; line-height: 1.2; font-family: Arial, Helvetica Neue, Helvetica, sans-serif;\">\n"
                + "																		<p\n"
                + "																			style=\"margin: 0; font-size: 14px; text-align: center; letter-spacing: normal;\">\n"
                + "																			<span style=\"font-size:22px;\">C??ng ty CFL\n"
                + "																				CINEMA c???m ??n qu?? kh??ch ???? tin t?????ng,\n"
                + "																				?????ng h??nh c??ng ch??ng t??i trong qu?? tr??nh\n"
                + "																				ph??t tri???n. Nay ch??ng t??i t??? ch???c s??? ki???n khuy???n m??i <strong style=\"font-size: 25px\">" + tenSuKien + "</strong>"
                + "                                                                                                                                                         ????? c???m ??n qu?? kh??ch, s??? ki???n n??y s??? gi???m gi?? l??n t???i <strong style=\"font-size: 25px\">" + phanTramGiam + "%" + "</strong> tr??n t???ng ti???n h??a ????n."
                + "                                                                                                                                                         Ch??c qu?? kh??ch m???t ng??y t???t l??nh v?? h???n g???p qu?? kh??ch ??? m???t ng??y s???m nh???t\n"
                + "																				</span></p>\n"
                + "																	</div>\n"
                + "																</div>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "														class=\"image_block\" role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td\n"
                + "																style=\"padding-top:25px;width:100%;padding-right:0px;padding-left:0px;\">\n"
                + "																<div align=\"center\" style=\"line-height:10px\"><img\n"
                + "																		alt=\"Beer\"\n"
                + "																		src=\"cid:imgPhimChinh\"\n"
                + "																		style=\"display: block; height: auto; border: 0; width: 295px; max-width: 100%;\"\n"
                + "																		title=\"Beer\" width=\"295\" /></div>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "														class=\"button_block\" role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td style=\"padding-top:40px;text-align:center;\">\n"
                + "																<div align=\"center\">\n"
                + "																	<!--[if mso]><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"http://www.example.com/\" style=\"height:54px;width:480px;v-text-anchor:middle;\" arcsize=\"8%\" stroke=\"false\" fillcolor=\"#e44500\"><w:anchorlock/><v:textbox inset=\"0px,0px,0px,0px\"><center style=\"color:#ffffff; font-family:Arial, sans-serif; font-size:22px\"><![endif]--><a\n"
                + "																		href=\"http://www.example.com/\"\n"
                + "																		style=\"text-decoration:none;display:inline-block;color:#ffffff;background-color:#e44500;border-radius:4px;width:auto;border-top:1px solid #e44500;border-right:1px solid #e44500;border-bottom:1px solid #e44500;border-left:1px solid #e44500;padding-top:5px;padding-bottom:5px;font-family:Arial, Helvetica Neue, Helvetica, sans-serif;text-align:center;mso-border-alt:none;word-break:keep-all;\"\n"
                + "																		target=\"_blank\"><span\n"
                + "																			style=\"padding-left:25px;padding-right:25px;font-size:22px;display:inline-block;letter-spacing:1px;\"><span\n"
                + "																				style=\"font-size: 16px; line-height: 2; word-break: break-word; mso-line-height-alt: 32px;\"><span\n"
                + "																					data-mce-style=\"font-size: 22px; line-height: 44px;\"\n"
                + "																					style=\"font-size: 22px; line-height: 44px;\">Th???i\n"
                + "																					gian k???t th??c khuy???n m??i: " + thoiGianKetThucSK + "?? ?? ?? ?? ?? ??\n"
                + "																					????</span></span></span></a>\n"
                + "																	<!--[if mso]></center></v:textbox></v:roundrect><![endif]-->\n"
                + "																</div>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"text_block\"\n"
                + "														role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td>\n"
                + "																<div\n"
                + "																	style=\"font-family: Georgia, 'Times New Roman', serif\">\n"
                + "																	<div\n"
                + "																		style=\"font-size: 14px; font-family: 'Bitter', Georgia, Times, 'Times New Roman', serif; mso-line-height-alt: 16.8px; color: #f8d888; line-height: 1.2;\">\n"
                + "																		<p\n"
                + "																			style=\"margin: 0; font-size: 14px; text-align: center; letter-spacing: -1px;\">\n"
                + "															<span style=\"font-size:88px;font-family: Arial\">SALE"
                + "																				" + phanTramGiam + "%" + "</span></p>\n"
                + "																	</div>\n"
                + "																</div>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "												</td>\n"
                + "											</tr>\n"
                + "										</tbody>\n"
                + "									</table>\n"
                + "								</td>\n"
                + "							</tr>\n"
                + "						</tbody>\n"
                + "					</table>\n"
                + "					<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-3\"\n"
                + "						role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n"
                + "						<tbody>\n"
                + "							<tr>\n"
                + "								<td>\n"
                + "									<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "										class=\"row-content stack\" role=\"presentation\"\n"
                + "										style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 640px;\"\n"
                + "										width=\"640\">\n"
                + "										<tbody>\n"
                + "											<tr>\n"
                + "												<td class=\"column\"\n"
                + "													style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 0px; padding-bottom: 0px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n"
                + "													width=\"100%\">\n"
                + "													<div class=\"spacer_block\"\n"
                + "														style=\"height:30px;line-height:30px;font-size:1px;\">???</div>\n"
                + "												</td>\n"
                + "											</tr>\n"
                + "										</tbody>\n"
                + "									</table>\n"
                + "								</td>\n"
                + "							</tr>\n"
                + "						</tbody>\n"
                + "					</table>\n"
                + "					<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-4\"\n"
                + "						role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n"
                + "						<tbody>\n"
                + "							<tr>\n"
                + "								<td>\n"
                + "									<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "										class=\"row-content stack\" role=\"presentation\"\n"
                + "										style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 640px;\"\n"
                + "										width=\"640\">\n"
                + "										<tbody>\n"
                + "											<tr>\n"
                + "												<td class=\"column\"\n"
                + "													style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-left: 25px; padding-right: 25px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n"
                + "													width=\"33.333333333333336%\">\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "														class=\"image_block\" role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td\n"
                + "																style=\"width:100%;padding-right:0px;padding-left:0px;padding-top:25px;\">\n"
                + "																<div align=\"center\" style=\"line-height:10px\"><img\n"
                + "																		alt=\"First\" src=\"cid:imgUuDiem1\"\n"
                + "																		style=\"display: block; height: auto; border: 0; width: 65px; max-width: 100%;\"\n"
                + "																		title=\"First\" width=\"65\" /></div>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "														class=\"heading_block\" role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td style=\"padding-top:15px;text-align:center;width:100%;\">\n"
                + "																<h3\n"
                + "																	style=\"margin: 0; color: #201616; direction: ltr; font-family: 'Bitter', Georgia, Times, 'Times New Roman', serif; font-size: 20px; font-weight: normal; letter-spacing: 1px; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\">\n"
                + "																	<strong>C??ng ngh??? cao</strong></h3>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"text_block\"\n"
                + "														role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td style=\"padding-top:10px;padding-bottom:25px;\">\n"
                + "																<div style=\"font-family: sans-serif\">\n"
                + "																	<div\n"
                + "																		style=\"font-size: 14px; mso-line-height-alt: 16.8px; color: #393d47; line-height: 1.2; font-family: Arial, Helvetica Neue, Helvetica, sans-serif;\">\n"
                + "																		<p\n"
                + "																			style=\"margin: 0; font-size: 14px; text-align: center;\">\n"
                + "																			<span style=\"font-size:16px;\">C??ng ngh??? cao\n"
                + "																				nh???t v???i nh???ng b??? phim 2D 3D v??\n"
                + "																				5D</span></p>\n"
                + "																	</div>\n"
                + "																</div>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "												</td>\n"
                + "												<td class=\"column\"\n"
                + "													style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-left: 25px; padding-right: 25px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n"
                + "													width=\"33.333333333333336%\">\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "														class=\"image_block\" role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td\n"
                + "																style=\"width:100%;padding-right:0px;padding-left:0px;padding-top:25px;\">\n"
                + "																<div align=\"center\" style=\"line-height:10px\"><img\n"
                + "																		alt=\"Second\" src=\"cid:imgUuDiem2\"\n"
                + "																		style=\"display: block; height: auto; border: 0; width: 56px; max-width: 100%;\"\n"
                + "																		title=\"Second\" width=\"56\" /></div>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "														class=\"heading_block\" role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td style=\"padding-top:15px;text-align:center;width:100%;\">\n"
                + "																<h3\n"
                + "																	style=\"margin: 0; color: #201616; direction: ltr; font-family: 'Bitter', Georgia, Times, 'Times New Roman', serif; font-size: 20px; font-weight: normal; letter-spacing: 1px; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\">\n"
                + "																	<strong>L?????ng phim</strong></h3>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"text_block\"\n"
                + "														role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td style=\"padding-top:10px;padding-bottom:25px;\">\n"
                + "																<div style=\"font-family: sans-serif\">\n"
                + "																	<div\n"
                + "																		style=\"font-size: 14px; mso-line-height-alt: 16.8px; color: #393d47; line-height: 1.2; font-family: Arial, Helvetica Neue, Helvetica, sans-serif;\">\n"
                + "																		<p\n"
                + "																			style=\"margin: 0; font-size: 14px; text-align: center;\">\n"
                + "																			<span style=\"font-size:16px;\">T??? h??o l?? ????n\n"
                + "																				v??? c?? s??? l?????ng phim chi???u r???p nhi???u nh???t\n"
                + "																				c??? n?????c</span></p>\n"
                + "																	</div>\n"
                + "																</div>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "												</td>\n"
                + "												<td class=\"column\"\n"
                + "													style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-left: 25px; padding-right: 25px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n"
                + "													width=\"33.333333333333336%\">\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "														class=\"image_block\" role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td\n"
                + "																style=\"width:100%;padding-right:0px;padding-left:0px;padding-top:25px;\">\n"
                + "																<div align=\"center\" style=\"line-height:10px\"><img\n"
                + "																		alt=\"Third\" src=\"cid:imgUuDiem3\"\n"
                + "																		style=\"display: block; height: auto; border: 0; width: 65px; max-width: 100%;\"\n"
                + "																		title=\"Third\" width=\"65\" /></div>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "														class=\"heading_block\" role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td style=\"padding-top:15px;text-align:center;width:100%;\">\n"
                + "																<h3\n"
                + "																	style=\"margin: 0; color: #201616; direction: ltr; font-family: 'Bitter', Georgia, Times, 'Times New Roman', serif; font-size: 20px; font-weight: normal; letter-spacing: 1px; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\">\n"
                + "																	<strong>Gi?? r???</strong></h3>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"text_block\"\n"
                + "														role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td style=\"padding-top:10px;padding-bottom:25px;\">\n"
                + "																<div style=\"font-family: sans-serif\">\n"
                + "																	<div\n"
                + "																		style=\"font-size: 14px; mso-line-height-alt: 16.8px; color: #393d47; line-height: 1.2; font-family: Arial, Helvetica Neue, Helvetica, sans-serif;\">\n"
                + "																		<p\n"
                + "																			style=\"margin: 0; font-size: 14px; text-align: center;\">\n"
                + "																			<span style=\"font-size:16px;\">Gi?? v?? r??? nh???t\n"
                + "																				th??? tr?????ng r???p chi???u phim</span></p>\n"
                + "																	</div>\n"
                + "																</div>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "												</td>\n"
                + "											</tr>\n"
                + "										</tbody>\n"
                + "									</table>\n"
                + "								</td>\n"
                + "							</tr>\n"
                + "						</tbody>\n"
                + "					</table>\n"
                + "					<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-5\"\n"
                + "						role=\"presentation\"\n"
                + "						style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff1e0; background-image: url('cid:imgBgBody2'); background-repeat: repeat;\"\n"
                + "						width=\"100%\">\n"
                + "						<tbody>\n"
                + "							<tr>\n"
                + "								<td>\n"
                + "									<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "										class=\"row-content stack\" role=\"presentation\"\n"
                + "										style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 640px;\"\n"
                + "										width=\"640\">\n"
                + "										<tbody>\n"
                + "											<tr>\n"
                + "												<td class=\"column\"\n"
                + "													style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-left: 25px; padding-right: 25px; padding-top: 60px; padding-bottom: 25px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n"
                + "													width=\"100%\">\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "														class=\"heading_block\" role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td style=\"text-align:center;width:100%;\">\n"
                + "																<h2\n"
                + "																	style=\"margin: 0; color: #383029; direction: ltr; font-family: 'Bitter', Georgia, Times, 'Times New Roman', serif; font-size: 42px; font-weight: normal; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\">\n"
                + "																	<strong>OUR MOVIES</strong></h2>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"text_block\"\n"
                + "														role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td style=\"padding-top:10px;\">\n"
                + "																<div style=\"font-family: sans-serif\">\n"
                + "																	<div\n"
                + "																		style=\"font-size: 14px; mso-line-height-alt: 16.8px; color: #393d47; line-height: 1.2; font-family: Arial, Helvetica Neue, Helvetica, sans-serif;\">\n"
                + "																		<p\n"
                + "																			style=\"margin: 0; font-size: 14px; text-align: center;\">\n"
                + "																			<span style=\"font-size:20px;\">H??y ?????n v??\n"
                + "																				tr???i nghi???m nh???ng b??? phim hay\n"
                + "																				nh???t??</span></p>\n"
                + "																	</div>\n"
                + "																</div>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "												</td>\n"
                + "											</tr>\n"
                + "										</tbody>\n"
                + "									</table>\n"
                + "								</td>\n"
                + "							</tr>\n"
                + "						</tbody>\n"
                + "					</table>\n"
                + "					<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-6\"\n"
                + "						role=\"presentation\"\n"
                + "						style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff1e0; background-image: url('cid:imgBgBody3'); background-repeat: repeat;\"\n"
                + "						width=\"100%\">\n"
                + "						<tbody>\n"
                + "							<tr>\n"
                + "								<td>\n"
                + "									<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "										class=\"row-content stack\" role=\"presentation\"\n"
                + "										style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 640px;\"\n"
                + "										width=\"640\">\n"
                + "										<tbody>\n"
                + "											<tr>\n"
                + "												<td class=\"column\"\n"
                + "													style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-left: 25px; padding-right: 25px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n"
                + "													width=\"33.333333333333336%\">\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "														class=\"image_block\" role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td\n"
                + "																style=\"width:100%;padding-right:0px;padding-left:0px;padding-top:25px;\">\n"
                + "																<div align=\"center\" style=\"line-height:10px\"><img\n"
                + "																		alt=\"First beer\" src=\"cid:imgPhim1\"\n"
                + "																		style=\"display: block; height: auto; border: 0; width: 163px; max-width: 100%;\"\n"
                + "																		title=\"First beer\" width=\"163\" /></div>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "														class=\"heading_block\" role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td style=\"padding-top:25px;text-align:center;width:100%;\">\n"
                + "																<h3\n"
                + "																	style=\"margin: 0; color: #201616; direction: ltr; font-family: 'Arial', Georgia, Times, 'Times New Roman', serif; font-size: 22px; font-weight: normal; letter-spacing: 1px; line-height: 120%; text-align: left; margin-top: 0; margin-bottom: 0;\">\n"
                + "																	" + listPhim.get(0).getTenPhim() + "</h3>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"text_block\"\n"
                + "														role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td style=\"padding-top:15px;padding-bottom:25px;\">\n"
                + "																<div style=\"font-family: sans-serif\">\n"
                + "																	<div\n"
                + "																		style=\"font-size: 14px; mso-line-height-alt: 16.8px; color: #393d47; line-height: 1.2; font-family: Arial, Helvetica Neue, Helvetica, sans-serif;\">\n"
                + "																		<p style=\"margin: 0; font-size: 14px;\"><span\n"
                + "																				style=\"font-size:16px;\"></span></p>\n"
                + "																	</div>\n"
                + "																</div>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "												</td>\n"
                + "												<td class=\"column\"\n"
                + "													style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-left: 25px; padding-right: 25px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n"
                + "													width=\"33.333333333333336%\">\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "														class=\"image_block\" role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td\n"
                + "																style=\"width:100%;padding-right:0px;padding-left:0px;padding-top:25px;\">\n"
                + "																<div align=\"center\" style=\"line-height:10px\"><img\n"
                + "																		alt=\"Second beer\" src=\"cid:imgPhim2\"\n"
                + "																		style=\"display: block; height: auto; border: 0; width: 163px; max-width: 100%;\"\n"
                + "																		title=\"Second beer\" width=\"163\" /></div>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "														class=\"heading_block\" role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td style=\"padding-top:25px;text-align:center;width:100%;\">\n"
                + "																<h3\n"
                + "																	style=\"margin: 0; color: #201616; direction: ltr; font-family: 'Arial', Georgia, Times, 'Times New Roman', serif; font-size: 22px; font-weight: normal; letter-spacing: 1px; line-height: 120%; text-align: left; margin-top: 0; margin-bottom: 0;\">\n"
                + "																	" + listPhim.get(1).getTenPhim() + "</h3>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"text_block\"\n"
                + "														role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td style=\"padding-top:15px;padding-bottom:25px;\">\n"
                + "																<div style=\"font-family: sans-serif\">\n"
                + "																	<div\n"
                + "																		style=\"font-size: 14px; mso-line-height-alt: 16.8px; color: #393d47; line-height: 1.2; font-family: Arial, Helvetica Neue, Helvetica, sans-serif;\">\n"
                + "																		<p style=\"margin: 0; font-size: 14px;\"><span\n"
                + "																				style=\"font-size:16px;\"></span></p>\n"
                + "																	</div>\n"
                + "																</div>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "												</td>\n"
                + "												<td class=\"column\"\n"
                + "													style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-left: 25px; padding-right: 25px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n"
                + "													width=\"33.333333333333336%\">\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "														class=\"image_block\" role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td\n"
                + "																style=\"width:100%;padding-right:0px;padding-left:0px;padding-top:25px;\">\n"
                + "																<div align=\"center\" style=\"line-height:10px\"><img\n"
                + "																		alt=\"Third beer\" src=\"cid:imgPhim3\"\n"
                + "																		style=\"display: block; height: auto; border: 0; width: 163px; max-width: 100%;\"\n"
                + "																		title=\"Third beer\" width=\"163\" /></div>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "														class=\"heading_block\" role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td style=\"padding-top:25px;text-align:center;width:100%;\">\n"
                + "																<h3\n"
                + "																	style=\"margin: 0; color: #201616; direction: ltr; font-family: 'Arial', Georgia, Times, 'Times New Roman', serif; font-size: 22px; font-weight: normal; letter-spacing: 1px; line-height: 120%; text-align: left; margin-top: 0; margin-bottom: 0;\">\n"
                + "																	" + listPhim.get(2).getTenPhim() + "</h3>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"text_block\"\n"
                + "														role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td style=\"padding-top:15px;padding-bottom:25px;\">\n"
                + "																<div style=\"font-family: sans-serif\">\n"
                + "																	<div\n"
                + "																		style=\"font-size: 14px; mso-line-height-alt: 16.8px; color: #393d47; line-height: 1.2; font-family: Arial, Helvetica Neue, Helvetica, sans-serif;\">\n"
                + "																		<p style=\"margin: 0; font-size: 14px;\"><span\n"
                + "																				style=\"font-size:16px;\"></span></p>\n"
                + "																	</div>\n"
                + "																</div>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "												</td>\n"
                + "											</tr>\n"
                + "										</tbody>\n"
                + "									</table>\n"
                + "								</td>\n"
                + "							</tr>\n"
                + "						</tbody>\n"
                + "					</table>\n"
                + "					<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-7\"\n"
                + "						role=\"presentation\"\n"
                + "						style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff1e0; background-image: url('cid:imgBgBody4'); background-repeat: repeat;\"\n"
                + "						width=\"100%\">\n"
                + "						<tbody>\n"
                + "							<tr>\n"
                + "								<td>\n"
                + "									<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "										class=\"row-content stack\" role=\"presentation\"\n"
                + "										style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 640px;\"\n"
                + "										width=\"640\">\n"
                + "										<tbody>\n"
                + "											<tr>\n"
                + "												<td class=\"column\"\n"
                + "													style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 0px; padding-bottom: 0px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n"
                + "													width=\"100%\">\n"
                + "													<div class=\"spacer_block\"\n"
                + "														style=\"height:50px;line-height:50px;font-size:1px;\">???</div>\n"
                + "												</td>\n"
                + "											</tr>\n"
                + "										</tbody>\n"
                + "									</table>\n"
                + "								</td>\n"
                + "							</tr>\n"
                + "						</tbody>\n"
                + "					</table>\n"
                + "					<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-8\"\n"
                + "						role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n"
                + "						<tbody>\n"
                + "							<tr>\n"
                + "								<td>\n"
                + "									<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "										class=\"row-content stack\" role=\"presentation\"\n"
                + "										style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 640px;\"\n"
                + "										width=\"640\">\n"
                + "										<tbody>\n"
                + "											<tr>\n"
                + "												<td class=\"column\"\n"
                + "													style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 0px; padding-bottom: 0px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n"
                + "													width=\"100%\">\n"
                + "													<div class=\"spacer_block\"\n"
                + "														style=\"height:50px;line-height:50px;font-size:1px;\">???</div>\n"
                + "												</td>\n"
                + "											</tr>\n"
                + "										</tbody>\n"
                + "									</table>\n"
                + "								</td>\n"
                + "							</tr>\n"
                + "						</tbody>\n"
                + "					</table>\n"
                + "					<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-9\"\n"
                + "						role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n"
                + "						<tbody>\n"
                + "							<tr>\n"
                + "								<td>\n"
                + "									<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "										class=\"row-content stack\" role=\"presentation\"\n"
                + "										style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 640px;\"\n"
                + "										width=\"640\">\n"
                + "										<tbody>\n"
                + "											<tr class=\"reverse\">\n"
                + "												<td class=\"column first\"\n"
                + "													style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-left: 25px; padding-right: 25px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n"
                + "													width=\"50%\">\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "														class=\"heading_block\" role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td style=\"text-align:center;width:100%;padding-top:25px;\">\n"
                + "																<h2\n"
                + "																	style=\"margin: 0; color: #383029; direction: ltr; font-family: 'Bitter', Georgia, Times, 'Times New Roman', serif; font-size: 42px; font-weight: normal; letter-spacing: normal; line-height: 120%; text-align: left; margin-top: 0; margin-bottom: 0;\">\n"
                + "																	ABOUT US</h2>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"text_block\"\n"
                + "														role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td style=\"padding-top:30px;\">\n"
                + "																<div style=\"font-family: sans-serif\">\n"
                + "																	<div\n"
                + "																		style=\"font-size: 14px; mso-line-height-alt: 21px; color: #393d47; line-height: 1.5; font-family: Arial, Helvetica Neue, Helvetica, sans-serif;\">\n"
                + "																		<p\n"
                + "																			style=\"margin: 0; font-size: 14px; text-align: left; mso-line-height-alt: 27px;\">\n"
                + "																			<span style=\"font-size:18px;\">V???i 5 n??m kinh\n"
                + "																				nghi???m r???p chi???u phim ??? Vi???t Nam n??i\n"
                + "																				ri??ng v?? 20 n??m ??? th??? gi???i n??i chung,\n"
                + "																				ch??ng t??i t??? h??o l?? ????n v??? ti??n phong\n"
                + "																				d???n ?????u trong ng??nh chi???u phim Vi???t Nam.\n"
                + "																				Ch??ng t??i cam k???t ??em ?????n cho qu?? kh??ch\n"
                + "																				nh???ng b??? phim hay nh???t v???i gi?? c??? ph???i\n"
                + "																				ch??ng. H??y ?????n v?? c???m nh???n c??ng ch??ng\n"
                + "																				t??i ????? c?? nh???ng ph??t gi??y th??ng hoa\n"
                + "																				nh???t</span></p>\n"
                + "																	</div>\n"
                + "																</div>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "														class=\"button_block\" role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td\n"
                + "																style=\"padding-top:35px;text-align:left;padding-bottom:25px;\">\n"
                + "																<!--[if mso]><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"http://www.example.com/\" style=\"height:54px;width:205px;v-text-anchor:middle;\" arcsize=\"8%\" stroke=\"false\" fillcolor=\"#e44500\"><w:anchorlock/><v:textbox inset=\"0px,0px,0px,0px\"><center style=\"color:#ffffff; font-family:Arial, sans-serif; font-size:22px\"><![endif]--><a\n"
                + "																	href=\"http://www.example.com/\"\n"
                + "																	style=\"text-decoration:none;display:inline-block;color:#ffffff;background-color:#e44500;border-radius:4px;width:auto;border-top:1px solid #e44500;border-right:1px solid #e44500;border-bottom:1px solid #e44500;border-left:1px solid #e44500;padding-top:5px;padding-bottom:5px;font-family:Arial, Helvetica Neue, Helvetica, sans-serif;text-align:center;mso-border-alt:none;word-break:keep-all;\"\n"
                + "																	target=\"_blank\"><span\n"
                + "																		style=\"padding-left:25px;padding-right:25px;font-size:22px;display:inline-block;letter-spacing:1px;\"><span\n"
                + "																			style=\"font-size: 16px; line-height: 2; word-break: break-word; mso-line-height-alt: 32px;\"><span\n"
                + "																				data-mce-style=\"font-size: 22px; line-height: 44px;\"\n"
                + "																				style=\"font-size: 22px; line-height: 44px;\">LEARN\n"
                + "																				MORE</span></span></span></a>\n"
                + "																<!--[if mso]></center></v:textbox></v:roundrect><![endif]-->\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "												</td>\n"
                + "												<td class=\"column last\"\n"
                + "													style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-left: 25px; padding-right: 25px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n"
                + "													width=\"50%\">\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "														class=\"image_block\" role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td\n"
                + "																style=\"width:100%;padding-right:0px;padding-left:0px;padding-top:25px;padding-bottom:25px;\">\n"
                + "																<div align=\"center\" style=\"line-height:10px\"><img\n"
                + "																		alt=\"Beer\" class=\"fullMobileWidth big\"\n"
                + "																		src=\"cid:imgAboutus\"\n"
                + "																		style=\"display: block; height: auto; border: 0; width: 270px; max-width: 100%;\"\n"
                + "																		title=\"Beer\" width=\"270\" /></div>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "												</td>\n"
                + "											</tr>\n"
                + "										</tbody>\n"
                + "									</table>\n"
                + "								</td>\n"
                + "							</tr>\n"
                + "						</tbody>\n"
                + "					</table>\n"
                + "					<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-10\"\n"
                + "						role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n"
                + "						<tbody>\n"
                + "							<tr>\n"
                + "								<td>\n"
                + "									<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "										class=\"row-content stack\" role=\"presentation\"\n"
                + "										style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 640px;\"\n"
                + "										width=\"640\">\n"
                + "										<tbody>\n"
                + "											<tr>\n"
                + "												<td class=\"column\"\n"
                + "													style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 0px; padding-bottom: 0px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n"
                + "													width=\"100%\">\n"
                + "													<div class=\"spacer_block\"\n"
                + "														style=\"height:50px;line-height:50px;font-size:1px;\">???</div>\n"
                + "												</td>\n"
                + "											</tr>\n"
                + "										</tbody>\n"
                + "									</table>\n"
                + "								</td>\n"
                + "							</tr>\n"
                + "						</tbody>\n"
                + "					</table>\n"
                + "					<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-11\"\n"
                + "						role=\"presentation\"\n"
                + "						style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #383029;\" width=\"100%\">\n"
                + "						<tbody>\n"
                + "							<tr>\n"
                + "								<td>\n"
                + "									<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "										class=\"row-content stack\" role=\"presentation\"\n"
                + "										style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 640px;\"\n"
                + "										width=\"640\">\n"
                + "										<tbody>\n"
                + "											<tr>\n"
                + "												<td class=\"column\"\n"
                + "													style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 0px; padding-bottom: 0px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n"
                + "													width=\"100%\">\n"
                + "													<div class=\"spacer_block\"\n"
                + "														style=\"height:50px;line-height:50px;font-size:1px;\">???</div>\n"
                + "												</td>\n"
                + "											</tr>\n"
                + "										</tbody>\n"
                + "									</table>\n"
                + "								</td>\n"
                + "							</tr>\n"
                + "						</tbody>\n"
                + "					</table>\n"
                + "					<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-12\"\n"
                + "						role=\"presentation\"\n"
                + "						style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #383029;\" width=\"100%\">\n"
                + "						<tbody>\n"
                + "							<tr>\n"
                + "								<td>\n"
                + "									<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "										class=\"row-content stack\" role=\"presentation\"\n"
                + "										style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 640px;\"\n"
                + "										width=\"640\">\n"
                + "										<tbody>\n"
                + "											<tr>\n"
                + "												<td class=\"column\"\n"
                + "													style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 0px; padding-bottom: 0px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n"
                + "													width=\"100%\">\n"
                + "													<div class=\"spacer_block\"\n"
                + "														style=\"height:50px;line-height:50px;font-size:1px;\">???</div>\n"
                + "												</td>\n"
                + "											</tr>\n"
                + "										</tbody>\n"
                + "									</table>\n"
                + "								</td>\n"
                + "							</tr>\n"
                + "						</tbody>\n"
                + "					</table>\n"
                + "					<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-13\"\n"
                + "						role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n"
                + "						<tbody>\n"
                + "							<tr>\n"
                + "								<td>\n"
                + "									<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "										class=\"row-content stack\" role=\"presentation\"\n"
                + "										style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 640px;\"\n"
                + "										width=\"640\">\n"
                + "										<tbody>\n"
                + "											<tr>\n"
                + "												<td class=\"column\"\n"
                + "													style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n"
                + "													width=\"100%\">\n"
                + "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "														class=\"icons_block\" role=\"presentation\"\n"
                + "														style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n"
                + "														width=\"100%\">\n"
                + "														<tr>\n"
                + "															<td\n"
                + "																style=\"color:#9d9d9d;font-family:inherit;font-size:15px;padding-bottom:5px;padding-top:5px;text-align:center;\">\n"
                + "																<table cellpadding=\"0\" cellspacing=\"0\"\n"
                + "																	role=\"presentation\"\n"
                + "																	style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n"
                + "																	width=\"100%\">\n"
                + "																	<tr>\n"
                + "																		<td style=\"text-align:center;\">\n"
                + "																			<!--[if vml]><table align=\"left\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\"><![endif]-->\n"
                + "																			<!--[if !vml]><!-->\n"
                + "																			<table cellpadding=\"0\" cellspacing=\"0\"\n"
                + "																				class=\"icons-inner\" role=\"presentation\"\n"
                + "																				style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block; margin-right: -4px; padding-left: 0px; padding-right: 0px;\">\n"
                + "																				<!--<![endif]-->\n"
                + "																				\n"
                + "																			</table>\n"
                + "																		</td>\n"
                + "																	</tr>\n"
                + "																</table>\n"
                + "															</td>\n"
                + "														</tr>\n"
                + "													</table>\n"
                + "												</td>\n"
                + "											</tr>\n"
                + "										</tbody>\n"
                + "									</table>\n"
                + "								</td>\n"
                + "							</tr>\n"
                + "						</tbody>\n"
                + "					</table>\n"
                + "				</td>\n"
                + "			</tr>\n"
                + "		</tbody>\n"
                + "	</table><!-- End -->\n"
                + "</body>\n"
                + "\n"
                + "</html>";
        return html;
    }

    public Map mapImage(List<Phim> listPhim) {

        // T???o map 
        Map<String, String> map = new HashMap<>();
        map.put("imgBgHeader", "images/bg_light__1___1___1___1___1___1_.png");
        map.put("imgBgBody1", "images/bg-texture__1___1_.png");
        map.put("imgGachDuoiTenKhach", "images/Group.png");
        map.put("imgPhimChinh", "images/rapPhim.png");
        map.put("imgUuDiem1", "images/quality-badge-star.png");
        map.put("imgUuDiem2", "images/water.png");
        map.put("imgUuDiem3", "images/hand.png");
        map.put("imgBgBody2", "images/bg_light__1___1___1___1___1___1_.png");
        map.put("imgBgBody3", "images/bg_light__1___1___1___1___1___1_.png");
        map.put("imgPhim1", "imagePhim/" + "MatBiec.jpg");
        map.put("imgPhim2", "imagePhim/" + "pvtd.jpg");
        map.put("imgPhim3", "imagePhim/" + "NguoiNhen.jpg");
        map.put("imgBgBody4", "images/bg_light__1___1___1___1___1___1_.png");
        map.put("imgAboutus", "images/d89f0523-ad7f-43e4-97ac-8df648461390.jpeg");

        return map;
    }
}
