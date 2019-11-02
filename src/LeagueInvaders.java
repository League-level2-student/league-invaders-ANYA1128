import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame = new JFrame();
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	GamePanel gPanel = new GamePanel();

	public static void main(String[] args) {
		LeagueInvaders invaders = new LeagueInvaders();
		invaders.setup();
	}

	LeagueInvaders() {
		this.frame = frame;
		this.gPanel = gPanel;
	}

	void setup() {
		frame.add(gPanel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.addKeyListener(gPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub

	}
}
