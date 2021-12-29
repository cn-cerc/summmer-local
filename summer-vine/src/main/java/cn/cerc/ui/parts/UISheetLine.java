package cn.cerc.ui.parts;

import cn.cerc.db.core.ClassResource;
import cn.cerc.ui.SummerUI;
import cn.cerc.ui.core.HtmlWriter;
import cn.cerc.ui.core.UIComponent;
import cn.cerc.ui.other.UrlMenu;

public class UISheetLine extends UISheet {
    private static final ClassResource res = new ClassResource(UISheetLine.class, SummerUI.ID);

    private UrlMenu operaUrl;

    public UISheetLine(UIComponent owner) {
        super(owner);
        this.setCaption(res.getString(1, "数据合计"));
    }

    @Override
    public void output(HtmlWriter html) {
        if (getComponents().size() == 0) {
            return;
        }
        html.println("<section");
        super.outputPropertys(html);
        html.println(">");
        html.print("<div class=\"title\">");
        html.print(this.getCaption());
        if (operaUrl != null) {
            operaUrl.output(html);
        }
        html.println("</div>");
        html.println("<div class=\"contents\">");
        html.println("<ul>");
        for (UIComponent component : getComponents()) {
            html.print("<li>");
            component.output(html);
            html.print("</li>");
        }
        html.println("</ul>");
        html.println("</div>");
        html.println("</section>");
    }

    public UrlMenu getOperaUrl() {
        if (operaUrl == null) {
            operaUrl = new UrlMenu(null);
            operaUrl.setCssStyle("float:right;margin-bottom:0.25em");
        }
        return operaUrl;
    }

    public void setOperaUrl(UrlMenu operaUrl) {
        this.operaUrl = operaUrl;
    }
}
