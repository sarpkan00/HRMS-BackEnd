package kodlamaio.HumanRMS.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HumanRMS.business.abstracts.CvLinkService;
import kodlamaio.HumanRMS.core.utilities.results.DataResult;
import kodlamaio.HumanRMS.core.utilities.results.Result;
import kodlamaio.HumanRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanRMS.core.utilities.results.SuccessResult;
import kodlamaio.HumanRMS.dataAccess.abstracts.CvLinkDao;
import kodlamaio.HumanRMS.entites.concretes.CvLink;

@Service
public class CvLinkManager implements CvLinkService {
	
	private CvLinkDao cvLinkDao;
	
	@Autowired
	public CvLinkManager(CvLinkDao cvLinkDao) {
		super();
		this.cvLinkDao = cvLinkDao;
	}

	@Override
	public Result add(CvLink cvLink) {
		this.cvLinkDao.save(cvLink);
		return new SuccessResult("Link has been added");
	}

	@Override
	public Result update(CvLink cvLink) {
		this.cvLinkDao.save(cvLink);
		return new SuccessResult("Link has been updated");
	}

	@Override
	public Result delete(int id) {
		this.cvLinkDao.deleteById(id);
		return new SuccessResult("Link has ben deleted");
	}

	@Override
	public DataResult<CvLink> getById(int id) {
		return new SuccessDataResult<CvLink>(this.cvLinkDao.getById(id));
	}
	
	@Override
	public DataResult<List<CvLink>> getAllByJobSeekerId(int id) {
		return new SuccessDataResult<List<CvLink>>(this.cvLinkDao.getAllByJobSeeker_Id(id));
	}

	@Override
	public DataResult<List<CvLink>> getAll() {
		return new SuccessDataResult<List<CvLink>>(this.cvLinkDao.findAll());
	}

	

}
