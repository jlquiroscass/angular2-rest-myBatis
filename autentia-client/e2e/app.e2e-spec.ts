import { AutentiaClientPage } from './app.po';

describe('autentia-client App', () => {
  let page: AutentiaClientPage;

  beforeEach(() => {
    page = new AutentiaClientPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
