package edu.uci.ics.crawler4j.crawler;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

/**
 * @author yeshengan
 * @since 2016年9月21日 下午5:19:02
 * @version 1.0.0
 * @TODO 
 */
public class Controller {
	public static void main(String[] args) throws Exception {
		String crawlStorageFolder = "E:/crawler";
		int numberOfCrawlers = 1;

		CrawlConfig config = new CrawlConfig();
		config.setCrawlStorageFolder(crawlStorageFolder);

		/*
		 * Instantiate the controller for this crawl.
		 */
		PageFetcher pageFetcher = new PageFetcher(config);
		RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
		RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig,
				pageFetcher);
		CrawlController controller = new CrawlController(config, pageFetcher,
				robotstxtServer);

		/*
		 * For each crawl, you need to add some seed urls. These are the first
		 * URLs that are fetched and then the crawler starts following links
		 * which are found in these pages
		 */
		controller.addSeed("http://ba.amac.org.cn/pages/amacWeb/user!list.action?filter_LIKES_CPMC=&filter_LIKES_GLJG=&filter_LIKES_CPBM=&filter_GES_SLRQ=&filter_LES_SLRQ=&page.searchFileName=publicity_web&page.sqlKey=PAGE_PUBLICITY_WEB&page.sqlCKey=SIZE_PUBLICITY_WEB&_search=false&nd=1474455594629&page.pageSize=50&page.pageNo=1&page.orderBy=SLRQ&page.order=desc");

		/*
		 * Start the crawl. This is a blocking operation, meaning that your code
		 * will reach the line after this only when crawling is finished.
		 */
		controller.start(MyCrawler.class, numberOfCrawlers);
	}
}
