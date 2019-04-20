/*
   Copyright 2019 Volker Berlin (i-net software)

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

*/
package de.inetsoftware.jwebassembly.module;

import java.util.Arrays;
import java.util.Iterator;

import de.inetsoftware.jwebassembly.wasm.AnyType;
import de.inetsoftware.jwebassembly.watparser.WatParser;

/**
 * Synthetic/dynamic method.
 * 
 * @author Volker Berlin
 */
abstract class SyntheticFunctionName extends FunctionName {

    private final AnyType[] signature;

    /**
     * Create a new instance.
     * 
     * @param name
     *            the function name
     * @param signature
     *            the method signature, first the parameters, then null and the the return types
     */
    public SyntheticFunctionName( String name, AnyType... signature ) {
        super( "", name, "()V" ); //TODO better signature name
        this.signature = signature;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<AnyType> getSignature() {
        return Arrays.asList( signature ).iterator();
    }

    /**
     * Get the WasmCodeBuilder.
     * 
     * @param watParser a helping WatParser
     * @return the code
     */
    abstract WasmCodeBuilder getCodeBuilder( WatParser watParser );
}
