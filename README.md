# Robocode
The Robot created by <b>Chunza2542</b> (Chun Rapeepat)<br>
* <b>Usage</b> [Installation the robot]<br>
<code>import robocode.util.Utils;</code>
<code>public class <RoboName> extends AdvancedRobot</code><br>
* <b>Methods</b> [Methods description]<br>
-<code>setAdjust ... For ... Turn(true); //Sets the .... to turn independent from the ..... turn.</code><br>
-<code>getX(), getY // get x,y left bottom is (0,0)</code><br>
-<code>getBattleFieldWidth(),getBattleFieldHeight() //Get width & Height of BattleField</code><br>
-<code>getRadarTurnRemaining() //Returns the angle remaining in the radar's turn, in radians.
This call returns both positive and negative values. Positive values means that the radar is currently turning to the right. Negative values means that the radar is currently turning to the left.</code><br>
-<code>execute() //continues executing actions that are in process. This call returns after the actions have been started.</code><br>
-<code>Utils.normalRelativeAngleDegrees // -180 to 180</code><br>
-<code>Utils.normalRelativeAngleDegrees // -180 to 180</code><br><br>

<b>EX.</b><code>//เซ็ตตัวแปร "องศาที่เรดาร์จะต้องหมุนเพิ่ม" ให้เท่ากับ<br>
    double radarTurn =<br>
        // องศาที่ตัวหุ่นยนต์ของเราหันอยู่เมื่อเทียบกับสนามรบ + องศาที่จุดค้นพบศัตรูเทียบกับองศาที่ตัวหุ่นยนต์เราหันอยู่<br>
        getHeadingRadians() + e.getBearingRadians()<br>
        // ลบด้วยองศาที่เรดาร์กำลังหันไปอยู่<br>
        - getRadarHeadingRadians();<br>
    //หมุนเรดาร์ไปทางขวาตามค่าของตัวแปร "องศาที่เรดาร์จะต้องหมุนเพิ่ม"<br>
    setTurnRadarRightRadians(Utils.normalRelativeAngle(radarTurn));<br></code>
