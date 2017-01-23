import { Anuglar2ClientPage } from './app.po';

describe('anuglar2-client App', function() {
  let page: Anuglar2ClientPage;

  beforeEach(() => {
    page = new Anuglar2ClientPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
