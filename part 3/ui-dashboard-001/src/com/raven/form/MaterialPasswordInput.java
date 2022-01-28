package com.raven.form;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class MaterialPasswordInput extends JPasswordField {
    
    private boolean isMouseOver = false;
    private final Animator animator;
    private float location;
    private boolean show;
    private boolean animateHintText = false;
    private String labelText = "Label1";
    private Color lineColor = new Color(3, 155, 216);
    
    public String getLabelText() {
        return labelText;
    }
    
    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }
    
    public Color getLineColor() {
        return lineColor;
    }
    
    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }
    
    public MaterialPasswordInput() {
        setBorder(new EmptyBorder(20, 3, 10, 3));
        setBackground(new Color(242, 242, 242));
        setSelectionColor(new Color(76, 204, 255));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isMouseOver = true;
                repaint();
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                isMouseOver = false;
                repaint();
            }
        });
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                showing(false);
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                showing(true);
            }
            
        });
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                animateHintText = String.valueOf(getPassword()).equals("");
            }
            
            @Override
            public void timingEvent(float fraction) {
                location = fraction;
                repaint();
            }
        };
        animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        
    }
    
    private void showing(boolean action) {
        if (animator.isRunning()) {
            animator.stop();
        } else {
            location = 1;
        }
        animator.setStartFraction(1f - location);
        show = action;
        location = 1f - location;
        animator.start();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        int width = getWidth();
        int height = getHeight();
        if (isMouseOver) {
            g2.setColor(new Color(250, 2, 229));
        } else {
            g2.setColor(new Color(150, 150, 150));
        }
        g2.fillRect(2, height - 1, width - 4, 1);
        createHintText(g2);
        createLineStyle(g2);
        g2.dispose();
    }
    
    private void createHintText(Graphics2D g2) {
        Insets in = getInsets();
        //g2.setColor(new Color(150, 150, 150));
        g2.setColor(lineColor);
        FontMetrics ft = g2.getFontMetrics();
        Rectangle2D r2 = ft.getStringBounds(labelText, g2);
        double height = getHeight() - in.top - in.bottom - 10; // -10 for additional space
        double textY = (height - r2.getHeight()) / 2;
        double size;
        if (animateHintText) {
            if (show) {
                size = 10 * (1 - location);
            } else {
                size = 10 * location;
            }
        } else {
            size = 10;
        }
        g2.drawString(labelText, in.right, (int) (in.top + textY + ft.getAscent() - size));
    }
    
    private void createLineStyle(Graphics2D g2) {
        if (isFocusOwner()) {
            double width = getWidth() - 4;
            int height = getHeight();
            g2.setColor(lineColor);
            double size;
            if (show) {
                size = width * (1 - location);
            } else {
                size = width * location;
            }
            double x = (width - size) / 2;
            g2.fillRect((int) (x + 2), height - 2, (int) size, 2);
            
        }
    }
    
    @Override
    public void setText(String t) {
        if (!String.valueOf(getPassword()).equals(t)) {
            showing(t.equals(""));
        }
        super.setText(t);
    }
    
}
