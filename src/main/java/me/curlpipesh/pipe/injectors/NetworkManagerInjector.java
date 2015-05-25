package me.curlpipesh.pipe.injectors;

import me.curlpipesh.bytecodetools.inject.Inject;
import me.curlpipesh.bytecodetools.inject.Injector;
import me.curlpipesh.pipe.util.Constants;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.List;

/**
 * Presently does nothing. Will eventually be responsible for packet events.
 *
 * @author c
 * @since 5/24/15
 */
//@Inject(Constants.NETWORKMANAGER)
public class NetworkManagerInjector extends Injector {
    @Override
    @SuppressWarnings("unchecked")
    protected void inject(ClassReader classReader, ClassNode classNode) {
        ((List<MethodNode>)classNode.methods).stream().filter(m -> m.name.equals("a"))
                .filter(m -> m.desc.equals(String.format("(%s[Lio.netty.util.concurrent.GenericFutureListener;)V", Constants.getByName("Packet").getDesc()))).forEach(m -> {
            // TODO Add packet send event
        });
    }
}
