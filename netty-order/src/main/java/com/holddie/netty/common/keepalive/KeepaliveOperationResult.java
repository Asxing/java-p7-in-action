package com.holddie.netty.common.keepalive;

import com.holddie.netty.common.OperationResult;
import lombok.Data;

@Data
public class KeepaliveOperationResult extends OperationResult {

    private final long time;
}
