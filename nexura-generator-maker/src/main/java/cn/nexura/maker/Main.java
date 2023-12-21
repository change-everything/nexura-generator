package cn.nexura.maker;

import cn.nexura.maker.cli.CommandExecutor;
import cn.nexura.maker.meta.Meta;
import cn.nexura.maker.meta.MetaManager;

public class Main {
    public static void main(String[] args) {
        Meta metaObject = MetaManager.getMetaObject();
        System.out.println(metaObject);
    }

}