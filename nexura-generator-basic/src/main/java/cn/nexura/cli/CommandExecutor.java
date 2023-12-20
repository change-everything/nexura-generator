package cn.nexura.cli;


import cn.nexura.cli.command.ConfigCommand;
import cn.nexura.cli.command.GenerateCommand;
import cn.nexura.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * @author PeiYP
 * @since 2023年12月20日 17:58
 */
@Command(name = "nexura", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable {

    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new ListCommand());
    }


    @Override
    public void run() {
        System.out.println("请输入具体命令，或者输入 --help 查看命令提示");
    }


    public Integer doExecute(String[] args) {
        return commandLine.execute(args);
    }
}
