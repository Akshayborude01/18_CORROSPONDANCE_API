package com.spring.user.service;

import java.awt.Color;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.spring.user.entities.AppUser;
import com.spring.user.entities.CoTrgEntity;
import com.spring.user.entities.EligibilityResponse;
import com.spring.user.entities.FinalResponse;
import com.spring.user.entities.PdfResponse;
import com.spring.user.repositories.AppUserRepo;
import com.spring.user.repositories.CoTrgRepository;
import com.spring.user.repositories.DcCaseRepository;
import com.spring.user.repositories.EligiRespRepository;
import com.spring.user.repositories.PdfResponseRepository;


public class ServiceImpl implements CoService {

	@Autowired
	private CoTrgRepository trgRepository;

	@Autowired
	private EligiRespRepository respRepository;

	@Autowired
	private AppUserRepo userRepo;

	@Autowired
	private DcCaseRepository dccaseRepo;
	
	@Autowired
	private PdfResponseRepository responseRepo;

	Long eligDatacasenum = null;
	Integer appId = null;
	CoTrgEntity entity = new CoTrgEntity();

	@Override
	public FinalResponse sendNotices() {

		PdfResponse response = new 	PdfResponse();
		
		CoTrgEntity entity = new CoTrgEntity();
		
	List<CoTrgEntity> trgStatus = trgRepository.findAllByTrgStatus();

	Optional<AppUser> userdataById = userRepo.findById(appId);
	EligibilityResponse eligdatabyCaseNum = respRepository.findByCaseNum(eligDatacasenum);

	appId = dccaseRepo.findByAppId(eligDatacasenum);

	if (("pending").equals(trgStatus)) {
		
		trgStatus.forEach(status -> {
			long eligDatacasenum = status.getCaseNum();

			response.setEmail(userdataById.get().getEmail());
			response.setMoNumber(userdataById.get().getMoNumber());
			response.setGender(userdataById.get().getGender());
			response.setDob(userdataById.get().getDob());
			response.setCaseNum(eligDatacasenum);
			response.setHolderSsn(eligDatacasenum);
			response.setHolderName(userdataById.get().getFname());
			response.setPlanName(eligdatabyCaseNum.getPlanName());
			response.setPlanStatus(eligdatabyCaseNum.getPlanStatus());
			response.setPlanStartDate(eligdatabyCaseNum.getPlanStartDate());
			response.setPlanEndDate(eligdatabyCaseNum.getPlanEndDate());
			response.setBenfitAmount(eligdatabyCaseNum.getBenfitAmount());
			response.setDeniedReason(eligdatabyCaseNum.getDeniedReason());
			
			PdfResponse save = responseRepo.save(response);

			entity.setCaseNum(eligDatacasenum);
			entity.setPdf(document);
			entity.setTrgStatus("Completed");
			
			});
		}

		return null;
	}

	public Document pdfreport(HttpServletResponse response) throws Exception {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("ELIGIBILITY_RESPONSE", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(8);

		table.setWidthPercentage(100f);
		// table.setWidths(new float[] { 1.5f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f });

		table.setWidths(new float[] { 1.5f, 3.5f, 3.0f, 3.0f, 1.5f, 3.0f, 1.5f });
		table.setSpacingBefore(10);

		// set table header data

		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.cyan);
		cell.setPadding(5);

		Font font1 = FontFactory.getFont(FontFactory.HELVETICA);
		font1.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("PdfId", font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("email", font1));

		table.addCell(cell);

		cell.setPhrase(new Phrase("moNumber", font1));
		table.addCell(cell);

		cell.setPhrase(new Phrase("gender", font1));
		table.addCell(cell);

		

		cell.setPhrase(new Phrase("dob", font1));
		table.addCell(cell);

		cell.setPhrase(new Phrase("caseNum", font1));
		table.addCell(cell);

		cell.setPhrase(new Phrase("holderName", font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("planName", font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("planStatus", font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("planStartDate", font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("planEndDate", font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("benfitAmount", font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("deniedReason", font1));
		table.addCell(cell);

		// set table data

		List<PdfResponse> record = responseRepo.findAll();

		for (PdfResponse records : record) {
			table.addCell(String.valueOf(records.getPdfId()));
			table.addCell(records.getEmail());
			table.addCell(String.valueOf(records.getMoNumber()));
			table.addCell(records.getGender());
			table.addCell(String.valueOf(records.getDob()));
			table.addCell(String.valueOf(records.getCaseNum()));	
			table.addCell(records.getHolderName());
			table.addCell(String.valueOf(records.getHolderSsn()));	
			table.addCell(records.getPlanName());
			table.addCell(records.getPlanStatus());
			table.addCell(String.valueOf(records.getPlanStartDate()));
			table.addCell(String.valueOf(records.getPlanEndDate()));
			table.addCell(String.valueOf(records.getBenfitAmount()));
			table.addCell(records.getDeniedReason());

			
		}

		document.add(table);

		document.close();
		
		return null;
}
}