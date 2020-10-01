package tanks.gui.screen;

import tanks.Drawing;
import tanks.Game;
import tanks.gui.Button;
import tanks.network.Client;

public class ScreenConfirmLeaveParty extends Screen implements IPartyMenuScreen
{
    public Button back = new Button(Drawing.drawing.interfaceSizeX / 2, Drawing.drawing.interfaceSizeY / 2 + 60, 350, 40, "Back", new Runnable()
    {
        @Override
        public void run()
        {
            Game.screen = new ScreenPartyLobby();
        }
    }
    );

    public Button confirm = new Button(Drawing.drawing.interfaceSizeX / 2, Drawing.drawing.interfaceSizeY / 2, 350, 40, "Leave party", new Runnable()
    {
        @Override
        public void run()
        {
            Drawing.drawing.playSound("leave.ogg");
            ScreenPartyLobby.isClient = false;
            Client.handler.ctx.close();
            Game.screen = new ScreenJoinParty();
            ScreenPartyLobby.connections.clear();
        }
    }
    );

    public ScreenConfirmLeaveParty()
    {
        this.music = "tomato_feast_4.ogg";
        this.musicID = "menu";
    }

    @Override
    public void update()
    {
        back.update();
        confirm.update();
    }

    @Override
    public void draw()
    {
        this.drawDefaultBackground();

        back.draw();
        confirm.draw();

        Drawing.drawing.setColor(0, 0, 0);
        Drawing.drawing.setInterfaceFontSize(24);
        Drawing.drawing.drawInterfaceText(Drawing.drawing.interfaceSizeX / 2, Drawing.drawing.interfaceSizeY / 2 - 100, "Are you sure you want to leave the party?");
    }
}
