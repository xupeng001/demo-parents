package org.design.proxy.bean;

public class Proxy extends Movie implements Action {

    Movie  movie;
    Action action;

    protected void prePlay() {
        System.out.println("prePlay");
    }

    protected void aftPlay() {
        System.out.println("aftPlay");
    }

    @Override
    public void play() {
        prePlay();
        movie.play();
        aftPlay();
    }

    protected void preKa() {
        System.out.println("preKa");
    }

    protected void aftKa() {
        System.out.println("aftKa");
    }

    @Override
    public void ka() {
        preKa();
        action.ka();
        aftKa();
    }

    /**
     * 初始化
     */
    protected void init() {
        movie = new Movie();
        action = new ActionImpl();
    }

    public Proxy() {
        init();
    }
}
