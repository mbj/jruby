/*
 ***** BEGIN LICENSE BLOCK *****
 * Version: CPL 1.0/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Common Public
 * License Version 1.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of
 * the License at http://www.eclipse.org/legal/cpl-v10.html
 *
 * Software distributed under the License is distributed on an "AS
 * IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * rights and limitations under the License.
 *
 * Copyright (C) 2002-2004 Anders Bengtsson <ndrsbngtssn@yahoo.se>
 * Copyright (C) 2001-2004 Jan Arne Petersen <jpetersen@uni-bonn.de>
 * Copyright (C) 2002 Benoit Cerrina <b.cerrina@wanadoo.fr>
 * Copyright (C) 2004-2007 Thomas E Enebo <enebo@acm.org>
 * Copyright (C) 2004 Stefan Matthias Aust <sma@3plus4.de>
 * 
 * Alternatively, the contents of this file may be used under the terms of
 * either of the GNU General Public License Version 2 or later (the "GPL"),
 * or the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the CPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the CPL, the GPL or the LGPL.
 ***** END LICENSE BLOCK *****/


////////////////////////////////////////////////////////////////////////////////
// NOTE: THIS FILE IS GENERATED! DO NOT EDIT THIS FILE!
// generated from: src/org/jruby/runtime/Block.erb
// using arities: src/org/jruby/runtime/Block.arities.erb
////////////////////////////////////////////////////////////////////////////////


package org.jruby.runtime;

import java.io.Serializable;
import org.jruby.RubyModule;
import org.jruby.RubyProc;
import org.jruby.runtime.builtin.IRubyObject;

/**
 *  Internal live representation of a block ({...} or do ... end).
 */
public final class Block implements Serializable {
    public enum Type { NORMAL, PROC, LAMBDA, THREAD }
    
    /**
     * The Proc that this block is associated with.  When we reference blocks via variable
     * reference they are converted to Proc objects.  We store a reference of the associated
     * Proc object for easy conversion.  
     */
    private RubyProc proc = null;
    
    public Type type = Type.NORMAL;
    
    private final Binding binding;
    
    private final BlockBody body;
    
    private boolean[] escaped = new boolean[] {false};
    
    /**
     * All Block variables should either refer to a real block or this NULL_BLOCK.
     */
    public static final Block NULL_BLOCK = new Block(BlockBody.NULL_BODY);

    public Block(BlockBody body, Binding binding) {
        this.body = body;
        this.binding = binding;
    }

    public Block(BlockBody body) {
        this.body = body;
        this.binding = null;
    }

    public IRubyObject call(ThreadContext context, IRubyObject[] args) {
        return body.call(context, args, binding, type);
    }

    public IRubyObject call(ThreadContext context, IRubyObject[] args, Block block) {
        return body.call(context, args, binding, type, block);
    }

    public IRubyObject call(ThreadContext context) {
        return body.call(context, binding, type);
    }
    public IRubyObject call(ThreadContext context, Block block) {
        return body.call(context, binding, type, block);
    }
    public IRubyObject yieldSpecific(ThreadContext context) {
        return body.yieldSpecific(context, binding, type);
    }
    public IRubyObject call(ThreadContext context, IRubyObject arg0) {
        return body.call(context, arg0, binding, type);
    }
    public IRubyObject call(ThreadContext context, IRubyObject arg0, Block block) {
        return body.call(context, arg0, binding, type, block);
    }
    public IRubyObject yieldSpecific(ThreadContext context, IRubyObject arg0) {
        return body.yieldSpecific(context, arg0, binding, type);
    }
    public IRubyObject call(ThreadContext context, IRubyObject arg0, IRubyObject arg1) {
        return body.call(context, arg0, arg1, binding, type);
    }
    public IRubyObject call(ThreadContext context, IRubyObject arg0, IRubyObject arg1, Block block) {
        return body.call(context, arg0, arg1, binding, type, block);
    }
    public IRubyObject yieldSpecific(ThreadContext context, IRubyObject arg0, IRubyObject arg1) {
        return body.yieldSpecific(context, arg0, arg1, binding, type);
    }
    public IRubyObject call(ThreadContext context, IRubyObject arg0, IRubyObject arg1, IRubyObject arg2) {
        return body.call(context, arg0, arg1, arg2, binding, type);
    }
    public IRubyObject call(ThreadContext context, IRubyObject arg0, IRubyObject arg1, IRubyObject arg2, Block block) {
        return body.call(context, arg0, arg1, arg2, binding, type, block);
    }
    public IRubyObject yieldSpecific(ThreadContext context, IRubyObject arg0, IRubyObject arg1, IRubyObject arg2) {
        return body.yieldSpecific(context, arg0, arg1, arg2, binding, type);
    }
    public IRubyObject call(ThreadContext context, IRubyObject arg0, IRubyObject arg1, IRubyObject arg2, IRubyObject arg3) {
        return body.call(context, arg0, arg1, arg2, arg3, binding, type);
    }
    public IRubyObject call(ThreadContext context, IRubyObject arg0, IRubyObject arg1, IRubyObject arg2, IRubyObject arg3, Block block) {
        return body.call(context, arg0, arg1, arg2, arg3, binding, type, block);
    }
    public IRubyObject yieldSpecific(ThreadContext context, IRubyObject arg0, IRubyObject arg1, IRubyObject arg2, IRubyObject arg3) {
        return body.yieldSpecific(context, arg0, arg1, arg2, arg3, binding, type);
    }
    public IRubyObject call(ThreadContext context, IRubyObject arg0, IRubyObject arg1, IRubyObject arg2, IRubyObject arg3, IRubyObject arg4) {
        return body.call(context, arg0, arg1, arg2, arg3, arg4, binding, type);
    }
    public IRubyObject call(ThreadContext context, IRubyObject arg0, IRubyObject arg1, IRubyObject arg2, IRubyObject arg3, IRubyObject arg4, Block block) {
        return body.call(context, arg0, arg1, arg2, arg3, arg4, binding, type, block);
    }
    public IRubyObject yieldSpecific(ThreadContext context, IRubyObject arg0, IRubyObject arg1, IRubyObject arg2, IRubyObject arg3, IRubyObject arg4) {
        return body.yieldSpecific(context, arg0, arg1, arg2, arg3, arg4, binding, type);
    }
    public IRubyObject call(ThreadContext context, IRubyObject arg0, IRubyObject arg1, IRubyObject arg2, IRubyObject arg3, IRubyObject arg4, IRubyObject arg5) {
        return body.call(context, arg0, arg1, arg2, arg3, arg4, arg5, binding, type);
    }
    public IRubyObject call(ThreadContext context, IRubyObject arg0, IRubyObject arg1, IRubyObject arg2, IRubyObject arg3, IRubyObject arg4, IRubyObject arg5, Block block) {
        return body.call(context, arg0, arg1, arg2, arg3, arg4, arg5, binding, type, block);
    }
    public IRubyObject yieldSpecific(ThreadContext context, IRubyObject arg0, IRubyObject arg1, IRubyObject arg2, IRubyObject arg3, IRubyObject arg4, IRubyObject arg5) {
        return body.yieldSpecific(context, arg0, arg1, arg2, arg3, arg4, arg5, binding, type);
    }
    public IRubyObject call(ThreadContext context, IRubyObject arg0, IRubyObject arg1, IRubyObject arg2, IRubyObject arg3, IRubyObject arg4, IRubyObject arg5, IRubyObject arg6) {
        return body.call(context, arg0, arg1, arg2, arg3, arg4, arg5, arg6, binding, type);
    }
    public IRubyObject call(ThreadContext context, IRubyObject arg0, IRubyObject arg1, IRubyObject arg2, IRubyObject arg3, IRubyObject arg4, IRubyObject arg5, IRubyObject arg6, Block block) {
        return body.call(context, arg0, arg1, arg2, arg3, arg4, arg5, arg6, binding, type, block);
    }
    public IRubyObject yieldSpecific(ThreadContext context, IRubyObject arg0, IRubyObject arg1, IRubyObject arg2, IRubyObject arg3, IRubyObject arg4, IRubyObject arg5, IRubyObject arg6) {
        return body.yieldSpecific(context, arg0, arg1, arg2, arg3, arg4, arg5, arg6, binding, type);
    }
    public IRubyObject call(ThreadContext context, IRubyObject arg0, IRubyObject arg1, IRubyObject arg2, IRubyObject arg3, IRubyObject arg4, IRubyObject arg5, IRubyObject arg6, IRubyObject arg7) {
        return body.call(context, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, binding, type);
    }
    public IRubyObject call(ThreadContext context, IRubyObject arg0, IRubyObject arg1, IRubyObject arg2, IRubyObject arg3, IRubyObject arg4, IRubyObject arg5, IRubyObject arg6, IRubyObject arg7, Block block) {
        return body.call(context, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, binding, type, block);
    }
    public IRubyObject yieldSpecific(ThreadContext context, IRubyObject arg0, IRubyObject arg1, IRubyObject arg2, IRubyObject arg3, IRubyObject arg4, IRubyObject arg5, IRubyObject arg6, IRubyObject arg7) {
        return body.yieldSpecific(context, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, binding, type);
    }
    public IRubyObject call(ThreadContext context, IRubyObject arg0, IRubyObject arg1, IRubyObject arg2, IRubyObject arg3, IRubyObject arg4, IRubyObject arg5, IRubyObject arg6, IRubyObject arg7, IRubyObject arg8) {
        return body.call(context, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, binding, type);
    }
    public IRubyObject call(ThreadContext context, IRubyObject arg0, IRubyObject arg1, IRubyObject arg2, IRubyObject arg3, IRubyObject arg4, IRubyObject arg5, IRubyObject arg6, IRubyObject arg7, IRubyObject arg8, Block block) {
        return body.call(context, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, binding, type, block);
    }
    public IRubyObject yieldSpecific(ThreadContext context, IRubyObject arg0, IRubyObject arg1, IRubyObject arg2, IRubyObject arg3, IRubyObject arg4, IRubyObject arg5, IRubyObject arg6, IRubyObject arg7, IRubyObject arg8) {
        return body.yieldSpecific(context, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, binding, type);
    }
    public IRubyObject call(ThreadContext context, IRubyObject arg0, IRubyObject arg1, IRubyObject arg2, IRubyObject arg3, IRubyObject arg4, IRubyObject arg5, IRubyObject arg6, IRubyObject arg7, IRubyObject arg8, IRubyObject arg9) {
        return body.call(context, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, binding, type);
    }
    public IRubyObject call(ThreadContext context, IRubyObject arg0, IRubyObject arg1, IRubyObject arg2, IRubyObject arg3, IRubyObject arg4, IRubyObject arg5, IRubyObject arg6, IRubyObject arg7, IRubyObject arg8, IRubyObject arg9, Block block) {
        return body.call(context, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, binding, type, block);
    }
    public IRubyObject yieldSpecific(ThreadContext context, IRubyObject arg0, IRubyObject arg1, IRubyObject arg2, IRubyObject arg3, IRubyObject arg4, IRubyObject arg5, IRubyObject arg6, IRubyObject arg7, IRubyObject arg8, IRubyObject arg9) {
        return body.yieldSpecific(context, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, binding, type);
    }


    public IRubyObject yield(ThreadContext context, IRubyObject value) {
        return body.yield(context, value, binding, type);
    }

    @Deprecated
    public IRubyObject yield(ThreadContext context, IRubyObject value, IRubyObject self, 
            RubyModule klass, boolean aValue) {
        return body.yield(context, value, self, klass, aValue, binding, type);
    }

    public IRubyObject yieldNonArray(ThreadContext context, IRubyObject value, IRubyObject self,
            RubyModule klass) {
        return body.yield(context, value, self, klass, false, binding, type);
    }

    public IRubyObject yieldArray(ThreadContext context, IRubyObject value, IRubyObject self,
            RubyModule klass) {
        return body.yield(context, value, self, klass, true, binding, type);
    }

    @Deprecated
    public IRubyObject yield(ThreadContext context, IRubyObject value, boolean aValue) {
        return body.yield(context, value, null, null, aValue, binding, type);
    }

    @Deprecated
    public IRubyObject yield(ThreadContext context, boolean aValue) {
        return body.yield(context, null, null, null, aValue, binding, type);
    }
    
    public Block cloneBlock() {
        Block newBlock = body.cloneBlock(binding);
        
        newBlock.type = type;
        newBlock.escaped = escaped;

        return newBlock;
    }

    /**
     * What is the arity of this block?
     * 
     * @return the arity
     */
    public Arity arity() {
        return body.arity();
    }

    /**
     * Retrieve the proc object associated with this block
     * 
     * @return the proc or null if this has no proc associated with it
     */
    public RubyProc getProcObject() {
    	return proc;
    }
    
    /**
     * Set the proc object associated with this block
     * 
     * @param procObject
     */
    public void setProcObject(RubyProc procObject) {
    	this.proc = procObject;
    }
    
    /**
     * Is the current block a real yield'able block instead a null one
     * 
     * @return true if this is a valid block or false otherwise
     */
    final public boolean isGiven() {
        return this != NULL_BLOCK;
    }
    
    public Binding getBinding() {
        return binding;
    }
    
    public BlockBody getBody() {
        return body;
    }

    /**
     * Gets the frame.
     * 
     * @return Returns a RubyFrame
     */
    public Frame getFrame() {
        return binding.getFrame();
    }
    
    public boolean isEscaped() {
        return escaped[0];
    }
    
    public void escape() {
        this.escaped[0] = true;
    }

    @Override
    public boolean equals(Object other) {
        if(this == other) {
            return true;
        }

        if(!(other instanceof Block)) {
            return false;
        }

        Block bOther = (Block)other;

        return this.binding.equals(bOther.binding) &&
            this.body == bOther.body;
    }
}
