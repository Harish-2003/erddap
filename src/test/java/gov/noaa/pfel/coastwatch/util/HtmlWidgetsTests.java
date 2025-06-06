package gov.noaa.pfel.coastwatch.util;

import com.cohort.util.File2;
import com.cohort.util.String2;
import com.cohort.util.TestUtil;
import com.cohort.util.XML;
import gov.noaa.pfel.erddap.util.EDStatic;
import org.junit.jupiter.api.BeforeAll;
import tags.TagAWS;
import tags.TagIncompleteTest;
import testDataset.Initialization;

class HtmlWidgetsTests {
  @BeforeAll
  static void init() {
    Initialization.edStatic();
  }

  /** This makes a test document and displays it in the browser. */
  @org.junit.jupiter.api.Test
  void basicTest() throws Throwable {
    // boolean oDebugMode = debugMode;
    // debugMode = true;
    String fullName = SSR.getTempDirectory() + "TestHtmlWidgets.html";
    String imageDir = EDStatic.config.imageDir;
    File2.delete(fullName);
    StringBuilder sb = new StringBuilder();
    boolean tHtmlTooltips = true;
    HtmlWidgets widgets = new HtmlWidgets(tHtmlTooltips, imageDir);
    // "http://localhost:8080/cwexperimental/images/");
    // "https://coastwatch.pfeg.noaa.gov/erddap/images/"); //SANS_SERIF_STYLE);
    sb.append(
        HtmlWidgets.DOCTYPE_HTML
            + "  <title>Test Html Widgets</title>\n"
            + "  <link href=\"http://localhost:8080/cwexperimental/images/erddap2.css\" rel=\"stylesheet\" type=\"text/css\">\n"
            + HtmlWidgets.leafletHead("http://localhost:8080/cwexperimental")
            +
            // myMouseMove_SCRIPT +
            "</head>\n"
            + "<body>\n"
            + HtmlWidgets.htmlTooltipScript(imageDir)
            + // this test uses non-https url
            HtmlWidgets.dragDropScript(imageDir)
            + // this test uses non-https url
            "<h1>Test Html Widgets</h1>\n"
            + HtmlWidgets.ifJavaScriptDisabled);
    sb.append(
        "This is using localhost erddap2.css and files from testMediaFiles.\n"
            + "<p>This is some text in the SANS_SERIF_STYLE.\n");
    sb.append(
        "<br>This html tooltip doesn't work initially because wings.gif height and width aren't specified: "
            + HtmlWidgets.htmlTooltipImage(
                imageDir + "QuestionMark.png",
                "?",
                "Hi <strong>bold</strong>\n<br>there \\/'\"&amp;&brvbar;!"
                    +
                    // height=\"331\" width=\"375\"
                    "<br><img src=\"https://www.cohortsoftware.com/wings.gif\" alt=\"wings\">",
                ""));
    sb.append(
        "<br>Large image scaled down to max=600:\n"
            + HtmlWidgets.imageInTooltip(
                "/programs/_tomcat/webapps/cwexperimental/images/HowDoISpecifyARegion.png",
                "http://localhost:8080/cwexperimental/images/HowDoISpecifyARegion.png",
                "http://localhost:8080/cwexperimental/images/QuestionMark.png"));

    sb.append(
        "<br>Small image (plus1000.gif):\n"
            + HtmlWidgets.imageInTooltip(
                "/programs/_tomcat/webapps/cwexperimental/images/plus1000.gif",
                "http://localhost:8080/cwexperimental/images/plus1000.gif",
                "http://localhost:8080/cwexperimental/images/QuestionMark.png"));

    // pure CSS image tooltip
    // try to defer loading the image
    sb.append("\n<br>cssTooltipImage: ");
    sb.append(
        HtmlWidgets.cssTooltipImage(
            "http://localhost:8080/cwexperimental/images/QuestionMark.png",
            "?",
            "",
            "http://localhost:8080/cwexperimental/files/testMediaFiles/ShouldWork/19020101.png",
            "img1"));
    sb.append("[something after]");

    sb.append("\n<br>cssTooltipVideo: ");
    sb.append(
        HtmlWidgets.cssTooltipVideo(
            "http://localhost:8080/cwexperimental/images/QuestionMark.png",
            "?",
            "",
            "http://localhost:8080/cwexperimental/files/testMediaFiles/ShouldWork/small.mp4"));
    sb.append("(testMediaFiles must be in localhost ERDDAP)");

    sb.append("\n<br>cssTooltipAudio: ");
    sb.append(
        HtmlWidgets.cssTooltipAudio(
            "http://localhost:8080/cwexperimental/images/QuestionMark.png",
            "?",
            "",
            "http://localhost:8080/cwexperimental/files/testMediaFiles/ShouldWork/M1F1-int16-AFsp.wav"));
    sb.append("(testMediaFiles must be in localhost ERDDAP)");

    sb.append("\n<br>cssTooltipImageBase64: ");
    sb.append(
        HtmlWidgets.cssTooltipImageBase64(
            "http://localhost:8080/cwexperimental/images/QuestionMark.png",
            "?",
            "",
            "data:image/png;base64,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",
            "img0",
            0));

    /*
     * sb.append(
     * "<a href=\"\" class=\"cssTooltip\">" +
     * "<img src=\"https://coastwatch.pfeg.noaa.gov/erddap/images/QuestionMark.png\" alt=\"?\" "
     * +
     * "onmouseover=\"var el=document.getElementById('img1'); el.setAttribute('src',el.getAttribute('data-src'));\">"
     * +
     * "<span>" +
     * "<strong>CSS only Tooltip</strong><br>And more.<br>" + //test text+image
     * "<img id=\"img1\" src=\"https://coastwatch.pfeg.noaa.gov/erddap/images/QuestionMark.png\" alt=\"jplMURSST20150103090000.png\" "
     * +
     * "data-src=\"http://localhost:8080/cwexperimental/files/testFileNames/jplMURSST20150103090000.png\">"
     * +
     * "</span></a>Subsequent text.\n");
     *
     * /* //original plain pre-load image
     * sb.append(
     * "<a href=\"#\" class=\"cssTooltip\">" +
     * "<img src=\"https://coastwatch.pfeg.noaa.gov/erddap/images/QuestionMark.png\" alt=\"?\">"
     * +
     * "<span>" +
     * "<strong>CSS only Tooltip</strong><br>And more.<br>" + //test text+image
     * "<img src=\"http://localhost:8080/cwexperimental/files/testFileNames/jplMURSST20150103090000.png\">"
     * + //" style=\"float:right;\"
     * "</span></a>Subsequent text.\n");
     */

    // audio
    sb.append(
        "\n<br>.wav (testMediaFiles must be in localhost ERDDAP):\n"
            + HtmlWidgets.htmlAudioControl(
                "http://localhost:8080/cwexperimental/files/testMediaFiles/ShouldWork/M1F1-int16-AFsp.wav"));

    String formName = "f1";
    int language = 0;
    sb.append(widgets.beginForm(formName, "GET", "testUrl", ""));
    sb.append(
        widgets.checkbox(
                "checkboxName1",
                "checkboxTooltip literal: &lt;&gt;&amp;\"!",
                true,
                "checkboxValue1",
                "rightLabel1",
                "")
            + "\n"
            + widgets.textField(
                "textFieldName1",
                "textFieldTooltip literal: &lt;&gt;&amp;\"!",
                10,
                255,
                "initialValue",
                "")
            + "<br>\n"
            + widgets.checkbox(
                "checkboxName2",
                "checkboxTooltip literal: &lt;&gt;&amp;\"!",
                true,
                "checkboxValue2",
                "rightLabel2",
                "")
            + "\n"
            + widgets.textField(
                "textFieldName2",
                "textFieldTooltip literal: &lt;&gt;&amp;\"!",
                10,
                255,
                "initialValue",
                "")
            + "<br>\n"
            + widgets.checkbox(
                "checkboxName3",
                "checkboxTooltip literal: &lt;&gt;&amp;\"!",
                true,
                "checkboxValue3",
                "rightLabel3",
                "")
            + "<br>\n"
            + widgets.checkbox(
                "checkboxName4",
                "checkboxTooltip literal: &lt;&gt;&amp;\"!",
                true,
                "checkboxValue4",
                "rightLabel4",
                "")
            + widgets.comment("This is a comment."));
    String options[] = new String[1200];
    for (int i = 0; i < 1200; i++)
      options[i] = i == 1 ? "1 (2 is empty)" : i == 2 ? "" : "option" + i;
    sb.append(
        "<br>\n"
            + widgets.radioButtons(
                "radioName1",
                "radioTooltip literal: &lt;&gt;&amp;\"!",
                true,
                new String[] {"apple", "banana", "cucumber"},
                1,
                "")
            + "<br>\n"
            + widgets.radioButtons(
                "radioName2",
                "radioTooltip literal: &lt;&gt;&amp;\"!",
                true,
                new String[] {"apple", "banana", "cucumber"},
                2,
                "")
            + widgets.select(
                "dropdownName",
                "dropdownTooltip literal: &lt;&gt;&amp;\"!",
                HtmlWidgets.BUTTONS_0n
                    + HtmlWidgets.BUTTONS_1
                    + HtmlWidgets.BUTTONS_100
                    + HtmlWidgets.BUTTONS_1000,
                options,
                37,
                "")
            + widgets.select(
                "selectName", "selectTooltip literal: &lt;&gt;&amp;\"!", 6, options, 137, "")
            + "<br>Password: \n"
            + "<input type=\"password\" name=\"mypassword\" autocomplete=\"off\">\n"
            + "<br>ComboBox: "
            + widgets.comboBox(
                language,
                formName,
                "myComboBox",
                "My comboBox tooltip",
                25,
                255,
                "myInitialValue",
                new String[] {"", "able", "baker", "charlie"},
                "",
                null)
            + // other
            "<br>TextField1: \n"
            + widgets.textField(
                "textFieldName1",
                "textFieldTooltip literal: &lt;&gt;&amp;\"!",
                10,
                255,
                "initialValue<script>prompt(123)</script>",
                "")
            + "<br>TextField2: \n"
            + widgets.textField(
                "textFieldName2",
                "",
                20,
                255,
                "has big tooltip <script>prompt(123)</script>",
                HtmlWidgets.htmlTooltip(
                    "Hi <strong>bold</strong>!\n<br>There \\/'\"&amp;&brvbar;!"))
            + "<br>\n"
            +
            // textbox
            "<textarea name=\"address\" cols=\"40\" rows=\"4\" maxlength=\"160\" wrap=\"soft\">"
            + "John Smith\n123 Main St\nAnytown, CA 94025\n"
            + XML.encodeAsHTMLAttribute("<>&\"<script>prompt(123)</script>\n")
            + "</textarea>\n"
            + "<br>\n"
            + widgets.hidden("testHiddenName", "hiddenValue")
            + widgets.button(
                "button",
                "button1",
                "button tooltip  literal: &lt;&gt;&amp;\"!",
                "Skinny Button",
                "class=\"skinny\"")
            +
            // make a button that looks like a submit button but doesn't submit the form
            "<br>\n"
            + widgets.button(
                "button",
                "submit1Name",
                "submit tooltip  literal: &lt;&gt;&amp;\"!",
                "Submit",
                "onclick=\"alert('alert!');\"")
            + "<br>\n"
            + widgets.htmlButton("button", "htmlbutton1", "value1", "tooltip", "labelHtml", "")
            + "<br>\n"
            + widgets.htmlButton("button", "htmlbutton2", "value2", "tooltip", "labelHtml", "")
            + "<br>\n"
            + widgets.color17("Color1: ", "color1", "Pick a color.", 2, "")
            + widgets.color17("Color2: ", "color2", "Pick a color.", 6, "")
            + "some other text\n");

    // sliders
    String fromNames[] = {"f1.from0", "f1.from1", "", "f1.from3", "f1.from4", "f1.from5"};
    String toNames[] = {"f1.to0", "", "", "f1.to3", "f1.to4", "f1.to5"};
    int nThumbs[] = {2, 1, 0, 2, 2, 1};
    String userValuesCsvs[] = {
      "\"a\",\"b\",\"c\",\"d\"",
      "\"B\",\"o\",\"b\"",
      null,
      "1,2,4,8,16,32,64,128",
      "\"only\"",
      "\"only\""
    };
    int initFromPositions[] = {200, 100, 0, 0, 0, 100};
    int initToPositions[] = {300, 500, 0, 500, 500, 500};
    int bgWidth = 500;
    // see sliderScript below

    sb.append(
        "<table class=\"compact\">\n"
            + "\n"
            + "<tr><td>Raw values: \n"
            + "Min: "
            + widgets.textField("from0", "", 10, 10, "sliderFrom0", "")
            + "\n"
            + "Max: "
            + widgets.textField("to0", "", 10, 10, "sliderTo0", "")
            + "\n"
            + "</td></tr>\n"
            + "<tr><td>\n"
            + widgets.dualSlider(0, bgWidth, "")
            + // was "style=\"text-align:left\""
            "</td></tr>\n"
            + "\n"
            + "<tr><td>Raw values: \n"
            + "Min: "
            + widgets.textField("from1", "", 10, 10, "sliderFrom1", "")
            + "\n"
            + "</td></tr>\n"
            + "\n"
            + "<tr><td>\n"
            + widgets.slider(1, bgWidth, "")
            + // was "style=\"text-align:left\"") +
            "</td></tr>\n"
            + "\n"
            + "<tr><td>Raw values: \n"
            + "Min: "
            + widgets.textField("from3", "", 10, 10, "sliderFrom3", "")
            + "\n"
            + "Max: "
            + widgets.textField("to3", "", 10, 10, "sliderTo3", "")
            + "\n"
            + "</td></tr>\n"
            + "<tr><td>\n"
            + widgets.dualSlider(3, bgWidth, "")
            + // was style=\"text-align:left\"") +
            "</td></tr>\n"
            + "<tr><td>Raw values: \n"
            + "Min: "
            + widgets.textField("from4", "", 10, 10, "sliderFrom4", "")
            + "\n"
            + "Max: "
            + widgets.textField("to4", "", 10, 10, "sliderTo4", "")
            + "\n"
            + "</td></tr>\n"
            + "<tr><td>\n"
            + widgets.dualSlider(4, bgWidth, "")
            + // was "style=\"text-align:left\"") +
            "</td></tr>\n"
            + "<tr><td>Raw values: \n"
            + "Min: "
            + widgets.textField("from5", "", 10, 10, "sliderFrom5", "")
            + "\n"
            + "</td></tr>\n"
            + "<tr><td>\n"
            + widgets.slider(5, bgWidth, "")
            + // was "style=\"text-align:left\"") +
            "</td></tr>\n"
            + "<tr><td>Chars 128-143: "
            + XML.encodeAsHTML(
                "\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\u008a\u008b\u008c\u008d\u008e\u008f")
            + "</td></tr>\n"
            + "<tr><td>Chars 144-159: "
            + XML.encodeAsHTML(
                "\u0090\u0091\u0092\u0093\u0094\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\u009f")
            + "</td></tr>\n"
            + "<tr><td>Chars 160-175: "
            + XML.encodeAsHTML(
                "\u00a0\u00a1\u00a2\u00a3\u00a4\u00a5\u00a6\u00a7\u00a8\u00a9\u00aa\u00ab\u00ac\u00ad\u00ae\u00af")
            + "</td></tr>\n"
            + "<tr><td>Char 255 (y uml): "
            + XML.encodeAsHTML("\u00ff")
            + "</td></tr>\n"
            + "<tr><td>Euro \\u20AC encodedAsHtml="
            + XML.encodeAsHTML("\u20AC")
            + " and as a raw character=\u20AC in this UTF-8 file."
            + "</td></tr>\n"
            + "\n"
            + "<tr><td>\n"
            + "Something Else\n"
            + "</td></tr>\n"
            + "<tr><td>"
            + "<img src=\""
            + imageDir
            + "arrow2U.gif\" alt=\"2U\">"
            + "<img src=\""
            + imageDir
            + "arrow2D.gif\" alt=\"2D\">"
            + "<img src=\""
            + imageDir
            + "arrow2L.gif\" alt=\"2L\">"
            + "<img src=\""
            + imageDir
            + "arrow2R.gif\" alt=\"2R\">"
            + "<img src=\""
            + imageDir
            + "arrowU.gif\" alt=\"up\">"
            + "<img src=\""
            + imageDir
            + "arrowD.gif\" alt=\"down\">"
            + "<img src=\""
            + imageDir
            + "arrowL.gif\" alt=\"left\">"
            + "<img src=\""
            + imageDir
            + "arrowR.gif\" alt=\"right\">"
            + "<img src=\""
            + imageDir
            + "arrowUU.gif\" alt=\"UU\">"
            + "<img src=\""
            + imageDir
            + "arrowDD.gif\" alt=\"DD\">"
            + "<img src=\""
            + imageDir
            + "arrowLL.gif\" alt=\"LL\">"
            + "<img src=\""
            + imageDir
            + "arrowRR.gif\" alt=\"RR\">"
            + "<img src=\""
            + imageDir
            + "minus.gif\" alt=\"-\">"
            + "<img src=\""
            + imageDir
            + "minus10.gif\" alt=\"-10\">"
            + "<img src=\""
            + imageDir
            + "minus100.gif\" alt=\"-100\">"
            + "<img src=\""
            + imageDir
            + "minus1000.gif\" alt=\"-1000\">"
            + "<img src=\""
            + imageDir
            + "minusminus.gif\" alt=\"--\">"
            + "<img src=\""
            + imageDir
            + "plus.gif\" alt=\"+\">"
            + "<img src=\""
            + imageDir
            + "plus10.gif\" alt=\"+10\">"
            + "<img src=\""
            + imageDir
            + "plus100.gif\" alt=\"+100\">"
            + "<img src=\""
            + imageDir
            + "plus1000.gif\" alt=\"+1000\">"
            + "<img src=\""
            + imageDir
            + "plusplus.gif\" alt=\"++\">\n"
            + "<br>"
            + "<img src=\""
            + imageDir
            + "data.gif\" alt=\"data\">"
            + "<img src=\""
            + imageDir
            + "i.gif\" alt=\"i\">"
            + "<img src=\""
            + imageDir
            + "resize.gif\" alt=\"resize\">"
            + "<img src=\""
            + imageDir
            + "source.gif\" alt=\"source\">"
            + "<img src=\""
            + imageDir
            + "title.gif\" alt=\"title\">"
            + "<img src=\""
            + imageDir
            + "URL.gif\" alt=\"URL\">"
            + "<img src=\""
            + imageDir
            + "x.gif\" alt=\"x\">\n"
            + "</td></tr>\n"
            + "</table>\n");

    // twoClickMap
    // String twoClickMap[] = myTwoClickMap540(language, formName, imageDir +
    // "world540.png", false); // debugInBrowser
    // String twoClickMap[] = myTwoClickMap180Big(language, formName, imageDir +
    // "worldPM180Big.png", false); // "debugInBrowser
    // String twoClickMap[] = myTwoClickMap360Big(language, formName, imageDir +
    // "world0360Big.png", false); // debugInBrowser
    String twoClickMap[] =
        HtmlWidgets.myTwoClickMap540Big(
            language, formName, imageDir + "world540Big.png", false); // debugInBrowser

    sb.append(
        "<table class=\"compact\">\n"
            + "<tr>\n"
            + "  <td>MinLon: "
            + widgets.textField("minLon", "", 5, 5, "220", "")
            + "</td>\n"
            + "  <td rowSpan=7 class=\"N\">"
            + twoClickMap[0]
            + "text on same row!"
            + twoClickMap[1]
            + "</td>\n"
            + "</tr>\n"
            + "<tr><td>MaxLon: "
            + widgets.textField("maxLon", "", 5, 5, "250", "")
            + "</td></tr>\n"
            + "<tr><td>MinLat: "
            + widgets.textField("minLat", "", 5, 5, "20", "")
            + "</td></tr>\n"
            + "<tr><td>MaxLat: "
            + widgets.textField("maxLat", "", 5, 5, "50", "")
            + "</td></tr>\n"
            + "<tr><td>Row 5</td></tr>\n"
            + "<tr><td>Row 6</td></tr>\n"
            + "<tr><td>Row 7</td></tr>\n"
            + "</table>\n");
    sb.append(widgets.endForm());
    sb.append(twoClickMap[2]);
    // sb.append("<img
    // src=\"https://coastwatch.pfeg.noaa.gov/erddap/griddap/erdGAssta8day.png?sst[(last)][(0.0)][(22):(50)][(225):(255)]%26.draw=surface%26.vars=longitude|latitude|sst%26.colorBar=Rainbow|C|Linear|8|32|\"
    // alt=\"ERDDAP: SST, GOES Imager (8 Day Composite)\">\n");

    sb.append(
        widgets.sliderScript(
            fromNames,
            toNames,
            nThumbs,
            userValuesCsvs,
            initFromPositions,
            initToPositions,
            bgWidth));

    // image in leaflet
    sb.append(
        "  <div id=\"map2\" style=\"width:600px; height:400px;\" ></div>\n"
            + "  <script>\n"
            + "    var map2 = L.map('map2', {crs: L.CRS.Simple, minZoom:-10});\n"
            + "    var bounds2 = [[0,0], [1000,1000]];\n"
            + // image is w=3936 h=4270
            "    var image2 = L.imageOverlay('"
            + "http://localhost:8080/cwexperimental/files/testMediaFiles/ShouldWork/19020101.png"
            + "', bounds2).addTo(map2);\n"
            + "    map2.fitBounds(bounds2);\n"
            + "  </script>\n");

    sb.append(
        "<p>&nbsp;\n"
            + "<p>&nbsp;\n"
            + "<p>&nbsp;\n"
            + "<p>&nbsp;\n"
            + "<p>&nbsp;\n"
            + "<p>&nbsp;\n"
            + "<p>&nbsp;\n"
            + "<p>&nbsp;\n"
            + "<p>&nbsp;\n"
            + "</body>\n"
            + "</html>\n");
    String2.log("writeToFile result=" + File2.writeToFileUtf8(fullName, sb.toString()));

    // TestUtil.displayInBrowser("file://" + fullName);
    // debugMode = oDebugMode;
  }

  @org.junit.jupiter.api.Test
  @TagAWS
  @TagIncompleteTest
  void testPublicAwsS3MediaFiles() {
    // String2.log("\n*** HtmlWidgets.testPublicAwsS3MediaFiles()\n" +
    // "Try viewing the images and videos to test range requests with public S3
    // buckets/files.");

    TestUtil.displayInBrowser(
        "http://localhost:8080/cwexperimental/files/testPrivateAwsS3MediaFiles/");

    // String2.pressEnterToContinue();
  }

  @org.junit.jupiter.api.Test
  @TagAWS
  @TagIncompleteTest
  void testPrivateAwsS3MediaFiles() {
    // String2.log("\n*** HtmlWidgets.testPrivateAwsS3MediaFiles()\n" +
    // "Try viewing the images and videos to test range requests with private S3
    // buckets/files.");

    TestUtil.displayInBrowser(
        "http://localhost:8080/cwexperimental/files/testPrivateAwsS3MediaFiles/");

    // String2.pressEnterToContinue();
  }
}
