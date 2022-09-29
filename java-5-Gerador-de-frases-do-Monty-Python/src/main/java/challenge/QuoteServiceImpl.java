package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	@Override
	public Quote getQuote() {
		List<Quote> quotesList = (List<Quote>) this.repository.findAll();
		Random rand = new Random();

		return quotesList.get(rand.nextInt(quotesList.size()));
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		List<Quote> quoteList = (List<Quote>) this.repository.findByActor(actor);
		Random rand = new Random();

		return quoteList.get(rand.nextInt(quoteList.size()));
	}

}
